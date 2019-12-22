package application.paperType.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import application.category.service.CategoryService;
import application.common.CommonUtil;
import application.common.Constants;
import application.domain.DataTableResults;
import application.paperType.bean.PaperTypeBean;
import application.paperType.bo.PaperTypeBO;
import application.paperType.form.PaperTypeForm;
import application.paperType.service.PaperTypeService;

@Controller
@RequestMapping("/paper-type")
public class PaperTypeController {
    @Autowired
    private PaperTypeService paperTypeService;
    
    @Autowired
    private CategoryService categoryService;
    
    private static String PAPERTYPE_PAGE ="paperTypePage";
    private static String PAPERTYPE_FORM ="paperTypeForm";
    private static String PAPERTYPE_LIST ="paperTypeList";
    
    @RequestMapping
    public String categoryPage(HttpServletRequest req, Model model) {
        return PAPERTYPE_PAGE;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String prepareAdd(HttpServletRequest req, Model model, PaperTypeForm form) {
        
        req.setAttribute("paperType", new PaperTypeBO());
        return PAPERTYPE_FORM;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String actionSave(HttpServletRequest req, Model model, PaperTypeForm form) throws Exception {
        Long id = CommonUtil.NVL(form.getId());
        
        
        PaperTypeBO bo;
        if(id>0L) {
            bo = paperTypeService.findById(id);
            bo.setModifiedBy(CommonUtil.getUserId(req));
            bo.setModifiedDate(new Date());
        } else {
            bo = new PaperTypeBO();
            bo.setCreatedBy(CommonUtil.getUserId(req));
            bo.setCreatedDate(new Date());
        }
        
        bo.setCode(form.getCode());
        bo.setName(form.getName());
        bo.setPaperLevelId(form.getPaperLevelId());
        bo.setResearchPoint(form.getResearchPoint());
        bo.setUnit(form.getUnit());
        bo.setUnitName(form.getUnitName());
        bo.setNote(form.getNote());
        
        paperTypeService.saveOrUpdate(bo);
        
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSave");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
    
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String search(HttpServletRequest req, Model model, PaperTypeForm form) {
        DataTableResults<PaperTypeBean>  lstTerm= paperTypeService.searchData(form, req);
        req.setAttribute("resultList", lstTerm.getData());
        return PAPERTYPE_LIST;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String prepareUpdate(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        PaperTypeBO bo = paperTypeService.findById(id);
        PaperTypeBean bean = new PaperTypeBean();
        CommonUtil.copyProperties(bean, bo);
        req.setAttribute("paperType", bean);
        return PAPERTYPE_FORM;
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
    public String actionDelete(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        PaperTypeBO bo = paperTypeService.findById(id);
        if(bo==null) {
            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
            req.setAttribute("message", "Bản ghi đã bị xóa!");
            return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
        }
        
        
        paperTypeService.delete(id);
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSave");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
}
