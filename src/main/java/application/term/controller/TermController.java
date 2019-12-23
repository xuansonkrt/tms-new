package application.term.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import application.category.bean.CategoryTypeBean;
import application.category.bo.CategoryBO;
import application.category.bo.CategoryTypeBO;
import application.category.form.CategoryForm;
import application.common.CommonUtil;
import application.common.Constants;
import application.domain.DataTableResults;
import application.term.bean.TermBean;
import application.term.bo.TermBO;
import application.term.form.TermForm;
import application.term.service.TermService;

@Controller
@RequestMapping("/term")
public class TermController {
    @Autowired
    private TermService termService;
    
    private static String TERM_PAGE ="termPage";
    private static String TERM_FORM ="termAdd";
    private static String TERM_LIST ="termList";
    
    @RequestMapping
    public String categoryPage(HttpServletRequest req, Model model) {
        List<TermBO> lstTerm= termService.findAll();
        req.setAttribute("lstTerm", lstTerm);
        return TERM_PAGE;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String prepareAdd(HttpServletRequest req, Model model, CategoryForm form) {
        req.setAttribute("term", new TermForm());
        return TERM_FORM;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String actionSave(HttpServletRequest req, Model model, TermForm form) throws Exception {
        Long id = CommonUtil.NVL(form.getId());
        
        /*
         * if(termService.checkCode(id, form.getCode())) {
         * req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
         * req.setAttribute("message", "Mã loại danh mục đã tồn tại!");
         * return UPDATE_AND_CLOSE;
         * }
         */
        
        TermBO bo;
        if(id>0L) {
            bo = termService.findById(id);
            bo.setModifiedBy(CommonUtil.getUserId(req));
            bo.setModifiedDate(new Date());
        } else {
            bo = new TermBO();
            bo.setCreatedBy(CommonUtil.getUserId(req));
            bo.setCreatedDate(new Date());
        }
        bo.setCode(form.getCode());
        bo.setName(form.getName());
        bo.setBeginDate(CommonUtil.convertStringToDate(form.getBeginDateShow()));
        bo.setEndDate(CommonUtil.convertStringToDate(form.getEndDateShow()));
        bo.setTheOrder(form.getTheOrder());
        bo.setYear(form.getYear());
        termService.saveOrUpdate(bo);
        
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSaveTerm");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
    
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String search(HttpServletRequest req, Model model, TermForm form) {
        DataTableResults<TermBean>  lstTerm= termService.searchData(form, req);
        req.setAttribute("lstTerm", lstTerm.getData());
        return TERM_LIST;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String prepareUpdate(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        TermBO bo = termService.findById(id);
        TermBean bean = new TermBean();
        CommonUtil.copyProperties(bean, bo);
        bean.setBeginDateShow(CommonUtil.convertDateToString(bo.getBeginDate()));
        bean.setEndDateShow(CommonUtil.convertDateToString(bo.getEndDate()));
        req.setAttribute("term", bean);
        return TERM_FORM;
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
    public String actionDelete(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        TermBO bo = termService.findById(id);
        if(bo==null) {
            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
            req.setAttribute("message", "Bản ghi đã bị xóa!");
            return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
        }
        
        
        termService.delete(id);
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSaveTerm");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
}
