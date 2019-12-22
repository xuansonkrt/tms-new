package application.category.controller;

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
import application.category.form.CategoryTypeForm;
import application.category.service.CategoryService;
import application.category.service.CategoryTypeService;
import application.common.CommonUtil;
import application.common.Constants;

@Controller
@RequestMapping("/category-type")
public class CategoryTypeController {

    @Autowired
    private CategoryTypeService categoryTypeService;
    
    @Autowired
    private CategoryService categoryService;
    
    private static String CATEGORY_TYPE_FORM ="categoryTypeAdd";
    private static String UPDATE_AND_CLOSE ="updateAndClose";
    private static String LIST_CATEGORY_TYPE ="lstCategoryType";
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String prepareAdd(HttpServletRequest req, Model model) {
        req.setAttribute("categoryType", new CategoryTypeForm());
        return CATEGORY_TYPE_FORM;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String prepareUpdate(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        CategoryTypeBO categoryTypeBO = categoryTypeService.findById(id);
        CategoryTypeBean bean = new CategoryTypeBean();
        CommonUtil.copyProperties(bean, categoryTypeBO);
        bean.setExpiredDateShow(CommonUtil.convertDateToString(categoryTypeBO.getExpiredDate()));
        bean.setEffectDateShow(CommonUtil.convertDateToString(categoryTypeBO.getEffectDate()));
        req.setAttribute("categoryType", bean);
        return CATEGORY_TYPE_FORM;
    }
    
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String actionSearch(HttpServletRequest req, Model model, CategoryTypeForm form) {
        List<CategoryTypeBean> lstCategoryType = categoryTypeService.getAllSearch(form.getName());
        req.setAttribute("lstCategoryType", lstCategoryType);
        return LIST_CATEGORY_TYPE;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String actionSave(HttpServletRequest req, Model model, CategoryTypeForm form) throws Exception {
        Long id = CommonUtil.NVL(form.getId());
        
        if(categoryTypeService.checkCode(id, form.getCode())) {
            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
            req.setAttribute("message", "Mã loại danh mục đã tồn tại!");
            return UPDATE_AND_CLOSE;
        }
        
        CategoryTypeBO bo;
        if(id>0L) {
            bo = categoryTypeService.findById(id);
            bo.setModifiedBy(CommonUtil.getUserId(req));
            bo.setModifiedDate(new Date());
        } else {
            bo = new CategoryTypeBO();
            bo.setCreatedBy(CommonUtil.getUserId(req));
            bo.setCreatedDate(new Date());
        }
        bo.setCode(form.getCode());
        bo.setName(form.getName());
        bo.setEffectDate(CommonUtil.convertStringToDate(form.getEffectDateShow()));
        bo.setExpiredDate(CommonUtil.convertStringToDate(form.getExpiredDateShow()));
       
        categoryTypeService.saveOrUpdate(bo);
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSaveCategoryType");
        return UPDATE_AND_CLOSE;
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
    public String actionDelete(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        CategoryTypeBO bo = categoryTypeService.findById(id);
        if(bo==null) {
            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
            req.setAttribute("message", "Bản ghi đã bị xóa!");
            return UPDATE_AND_CLOSE;
        }
        
        List<CategoryBO> lstCategoryBO = categoryService.findByCategoryTypeId(id);
        if(!CommonUtil.isNullOrEmpty(lstCategoryBO)) {
            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
            req.setAttribute("message", "Tồn tại bản ghi con!");
            return UPDATE_AND_CLOSE;
        }
        
        categoryTypeService.delete(id);
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSaveCategoryType");
        return UPDATE_AND_CLOSE;
    }
}
