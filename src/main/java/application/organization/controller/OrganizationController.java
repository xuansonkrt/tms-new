package application.organization.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import application.common.CommonUtil;
import application.common.Constants;
import application.common.ConverterJSON;
import application.domain.DataTableResults;
import application.organization.bean.Node;
import application.organization.bean.OrganizationBean;
import application.organization.bean.TreeBean;
import application.organization.bo.OrganizationBO;
import application.organization.form.OrganizationForm;
import application.organization.service.OrganizationService;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
    
    @Autowired
    private OrganizationService organizationService;
    
    private static String ORGANIZATION_PAGE ="organizationPage";
    private static String ORGANIZATION_LIST ="organizationList";
    private static String ORGANIZATION_FORM ="organizationForm";
    private static String ORGANIZATION_POPUP ="organizationPopup";
    private static String ORGANIZATION_POPUP_LIST ="organizationPopupList";
    
    @RequestMapping
    public String categoryPage(HttpServletRequest req, Model model) {
        return ORGANIZATION_PAGE;
    }
    
    @RequestMapping(value="/get-root",  produces = "application/json; charset=utf-8", method=RequestMethod.GET)
    @ResponseBody
    public  <T> String  getRoot(HttpServletRequest req, Model model) throws JsonProcessingException {
        List<TreeBean> lst = organizationService.getRootTree();
        List<Node> lstNode = new ArrayList<>();
        if(!CommonUtil.isNullOrEmpty(lst)) {
            for (TreeBean node : lst) {
                lstNode.add(new Node(node.getId().toString(),node.getParent()==null?"#":node.getParent().toString(),node.getText()));
            }
        }
        return ConverterJSON.toJsonToString(lstNode) ;
    }
    
    @RequestMapping(value="/get-children/{id}", produces = "application/json; charset=utf-8", method=RequestMethod.GET)
    @ResponseBody
    public  <T> String getChildren(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws JsonProcessingException {
        List<TreeBean> lst = organizationService.getChilrenNode(id);
        List<Node> lstNode = new ArrayList<>();
        if(!CommonUtil.isNullOrEmpty(lst)) {
            for (TreeBean node : lst) {
                lstNode.add(new Node(node.getId().toString(),node.getParent()==null?"#":node.getParent().toString(),node.getText()));
            }
        }
        return ConverterJSON.toJsonToString(lstNode) ;
    }
    
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String search(HttpServletRequest req, Model model, OrganizationForm form) {
        DataTableResults<OrganizationBean>  lstTerm= organizationService.searchData(form, req);
        req.setAttribute("resultList", lstTerm.getData());
        return ORGANIZATION_LIST;
    }
    
    @RequestMapping(value="/search-popup", method=RequestMethod.GET)
    public String searchPopup(HttpServletRequest req, Model model, OrganizationForm form) {
        DataTableResults<OrganizationBean>  lstTerm= organizationService.searchData(form, req);
        req.setAttribute("resultList", lstTerm.getData());
        return ORGANIZATION_POPUP_LIST;
    }
    
    @RequestMapping(value= {"/add/{parentId}","/add"}, method=RequestMethod.GET)
    public String prepareAdd(HttpServletRequest req, Model model, OrganizationForm form, @PathVariable Map<String, String> pathVariables) {
        OrganizationForm vm = new OrganizationForm();
        if (pathVariables.containsKey("parentId")) {
            Long parentId =  new Long(pathVariables.get("parentId"));
         //   OrganizationBO parent = organizationService.findById(parentId);
            vm.setParentId(parentId);
        } 
        
        req.setAttribute("organization", vm);
        return ORGANIZATION_FORM;
    }
    
    @RequestMapping(value= {"/popup/{parentId}","/popup"}, method=RequestMethod.GET)
    public String orgSelecter(HttpServletRequest req, Model model, OrganizationForm form, @PathVariable Map<String, String> pathVariables) {
        OrganizationForm vm = new OrganizationForm();
        if (pathVariables.containsKey("parentId")) {
            Long parentId =  new Long(pathVariables.get("parentId"));
         //   OrganizationBO parent = organizationService.findById(parentId);
            vm.setParentId(parentId);
        } 
        
        req.setAttribute("organization", vm);
        return ORGANIZATION_POPUP;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String prepareUpdate(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        OrganizationBO bo = organizationService.findById(id);
        OrganizationBean bean = new OrganizationBean();
        CommonUtil.copyProperties(bean, bo);
        bean.setFoundedDateShow(CommonUtil.convertDateToString(bo.getFoundedDate()));
        req.setAttribute("organization", bean);
        return ORGANIZATION_FORM;
    }
    
    @RequestMapping(value="/info/{id}", method=RequestMethod.GET)
    @ResponseBody
    public OrganizationBO getById(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        OrganizationBO bo = organizationService.findById(id);
        return bo;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String actionSave(HttpServletRequest req, Model model, OrganizationForm form) throws Exception {
        Long id = CommonUtil.NVL(form.getId());
        OrganizationBO parent = new OrganizationBO();
        
        //check trungg user name
        
        if(CommonUtil.NVL(form.getParentId())>0L) {
            parent = organizationService.findById(form.getParentId());
            if(parent == null) {
                req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
                req.setAttribute("message", "Đơn vị cha không tồn tại");
                return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
            }
        }
         
        
        OrganizationBO bo;
        if(id>0L) {
            bo = organizationService.findById(id);
            bo.setModifiedBy(CommonUtil.getUserId(req));
            bo.setModifiedDate(new Date());
        } else {
            bo = new OrganizationBO();
            bo.setCreatedBy(CommonUtil.getUserId(req));
            bo.setCreatedDate(new Date());
        }
        bo.setCode(form.getCode());
        bo.setName(form.getName());
        bo.setNote(form.getNote());
        bo.setEmail(form.getEmail());
        bo.setPhoneNumber(form.getPhoneNumber());
        bo.setAddress(form.getAddress());
        bo.setTheOrder(form.getTheOrder());
        bo.setFoundedDate(CommonUtil.convertStringToDate(form.getFoundedDateShow()));
        bo.setParentId(form.getParentId());
        organizationService.saveOrUpdate(bo);
        if(CommonUtil.NVL(form.getParentId())>0L) { // cần xem lại chỗ này nếu rảnh
            bo.setLevel(parent.getLevel()+1L);
            bo.setPath(String.format("%s%s/", parent.getPath(),bo.getId()));
        } else {
            bo.setLevel(1L);
            bo.setPath(String.format("/%s/", bo.getId()));
        }
        organizationService.saveOrUpdate(bo);
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSave");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
    public String actionDelete(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        OrganizationBO bo = organizationService.findById(id);
        if(bo==null) {
            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
            req.setAttribute("message", "Bản ghi đã bị xóa!");
            return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
        }
        
        organizationService.delete(id);
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSave");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
}
