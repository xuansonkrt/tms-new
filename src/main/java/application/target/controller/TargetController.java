package application.target.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import application.category.bean.CategoryBean;
import application.category.bo.CategoryTypeBO;
import application.category.service.CategoryService;
import application.category.service.CategoryTypeService;
import application.common.CommonUtil;
import application.common.Constants;
import application.domain.DataTableResults;
import application.target.bean.TargetBean;
import application.target.bo.TargetBO;
import application.target.form.TargetForm;
import application.target.service.TargetService;
import application.term.bean.TermBean;
import application.term.form.TermForm;

@Controller
@RequestMapping("/target")
public class TargetController {
    @Autowired
    private TargetService targetService;
    
    @Autowired
    private CategoryTypeService categoryTypeService;
    
    @Autowired
    private CategoryService categoryService;
    
    private static String TARGET_PAGE ="targetPage";
    private static String TARGET_FORM ="targetForm";
    private static String TARGET_LIST ="targetList";
    
    @RequestMapping
    public String categoryPage(HttpServletRequest req, Model model) {
        return TARGET_PAGE;
    }
    
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String search(HttpServletRequest req, Model model, TermForm form) {
        req.setAttribute("lstTarget", targetService.getAll());
        return TARGET_LIST;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String prepareAdd(HttpServletRequest req, Model model, TargetForm form) {
        List<CategoryTypeBO> lstCategoryType = categoryTypeService.findAll();
        List<CategoryBean> lstCategory = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.CDNG);
        CategoryTypeBO categoryTypeBO = categoryTypeService.findOneByCodeIgnoreCase(Constants.CATEGORY_TYPE.CDNG);
        categoryTypeBO = categoryTypeBO==null? new CategoryTypeBO() : categoryTypeBO;
        
        req.setAttribute("target", new TargetBO());
        req.setAttribute("lstCategory", lstCategory);
        req.setAttribute("lstCategoryType",lstCategoryType);
        req.setAttribute("categoryTypeBO",categoryTypeBO);
        return TARGET_FORM;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String prepareUpdate(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        TargetBO bo = targetService.findById(id);
        TargetBean bean = new TargetBean();
        CommonUtil.copyProperties(bean, bo);
        List<CategoryTypeBO> lstCategoryType = categoryTypeService.findAll();
        List<CategoryBean> lstCategory = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.CDNG);
        CategoryTypeBO categoryTypeBO = categoryTypeService.findOneByCodeIgnoreCase(Constants.CATEGORY_TYPE.CDNG);
        categoryTypeBO = categoryTypeBO==null? new CategoryTypeBO() : categoryTypeBO;
        
        req.setAttribute("target", bean);
        req.setAttribute("lstCategory", lstCategory);
        req.setAttribute("lstCategoryType",lstCategoryType);
        req.setAttribute("categoryTypeBO",categoryTypeBO);
        return TARGET_FORM;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String actionSave(HttpServletRequest req, Model model, TargetForm form) throws Exception {
        Long id = CommonUtil.NVL(form.getId());
        
        /*
         * if(termService.checkCode(id, form.getCode())) {
         * req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
         * req.setAttribute("message", "Mã loại danh mục đã tồn tại!");
         * return UPDATE_AND_CLOSE;
         * }
         */
        if(targetService.isDuplicate(form.getTheType(), form.getStaffPropertyId())) {
            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
            req.setAttribute("message", "Đã nhập định mức cho chức danh");
            return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
        }
        
        TargetBO bo;
        if(id>0L) {
            bo = targetService.findById(id);
            bo.setModifiedBy(CommonUtil.getUserId(req));
            bo.setModifiedDate(new Date());
        } else {
            bo = new TargetBO();
            bo.setCreatedBy(CommonUtil.getUserId(req));
            bo.setCreatedDate(new Date());
        }
        bo.setTheType(form.getTheType());
        bo.setStaffPropertyId(form.getStaffPropertyId());
        bo.setEduDuty(form.getEduDuty());
        bo.setResearchDuty(form.getResearchDuty());
        
        targetService.saveOrUpdate(bo);
        
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSave");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
    public String actionDelete(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        TargetBO bo = targetService.findById(id);
        if(bo==null) {
            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
            req.setAttribute("message", "Bản ghi đã bị xóa!");
            return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
        }
        
        
        targetService.delete(id);
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSave");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
}
