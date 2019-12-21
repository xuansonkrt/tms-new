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

import application.category.bean.CategoryBean;
import application.category.bean.CategoryTypeBean;
import application.category.bo.CategoryBO;
import application.category.bo.CategoryTypeBO;
import application.category.form.CategoryForm;
import application.category.form.CategoryTypeForm;
import application.category.service.CategoryService;
import application.category.service.CategoryTypeService;
import application.common.CommonUtil;
import application.common.Constants;
import application.domain.DataTableResults;

@Controller
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    private CategoryTypeService categoryTypeService;
    
    @Autowired
    private CategoryService categoryService;
    
    private static String CATEGORY_PAGE ="categoryPage";
    private static String CATEGORY_LIST ="categoryList";
    private static String CATEGORY_FORM ="categoryAdd";
    
    @RequestMapping
    public String categoryPage(HttpServletRequest req, Model model) {
        List<CategoryTypeBO> lstCategoryType= categoryTypeService.findAll();
        req.setAttribute("lstCategoryType", lstCategoryType);
        return CATEGORY_PAGE;
    }
    
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String search(HttpServletRequest req, Model model, CategoryForm form) {
        DataTableResults<CategoryBean>  lstCategory= categoryService.getCategory(form, req);
        req.setAttribute("lstCategory", lstCategory.getData());
        return CATEGORY_LIST;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String prepareAdd(HttpServletRequest req, Model model, CategoryForm form) {
        Long categoryTypeId = CommonUtil.NVL(form.getCategoryTypeId());
        CategoryBean bean = new CategoryBean();
        
        if(categoryTypeId > 0L) {
            CategoryTypeBO categoryTypeBO = categoryTypeService.findById(categoryTypeId);
            if(categoryTypeBO==null) {
                req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
                req.setAttribute("message", "Không tồn tại loại danh mục!");
                return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
            }
            bean.setCategoryTypeName(categoryTypeBO.getName());
            bean.setCategoryTypeId(categoryTypeBO.getId());
        }
        req.setAttribute("category", bean);
        return CATEGORY_FORM;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String prepareUpdate(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        CategoryBO categoryBO = categoryService.findById(id);
        CategoryBean bean = new CategoryBean();
        CommonUtil.copyProperties(bean, categoryBO);
        bean.setExpiredDateShow(CommonUtil.convertDateToString(categoryBO.getExpiredDate()));
        bean.setEffectDateShow(CommonUtil.convertDateToString(categoryBO.getEffectDate()));
        
        CategoryTypeBO categoryTypeBO = categoryTypeService.findById(categoryBO.getCategoryTypeId());
        if(categoryTypeBO!=null) {
            bean.setCategoryTypeName(categoryTypeBO.getName());
        }
        req.setAttribute("category", bean);
        return CATEGORY_FORM;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String actionSave(HttpServletRequest req, Model model, CategoryForm form) throws Exception {
        Long id = CommonUtil.NVL(form.getId());
        
        if(categoryService.checkCode(id, form.getCode())) {
            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
            req.setAttribute("message", "Mã danh mục đã tồn tại!");
            return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
        }
        
        CategoryBO bo;
        if(id>0L) {
            bo = categoryService.findById(id);
            bo.setModifiedBy(CommonUtil.getUserId(req));
            bo.setModifiedDate(new Date());
        } else {
            bo = new CategoryBO();
            bo.setCreatedBy(CommonUtil.getUserId(req));
            bo.setCreatedDate(new Date());
        }
        bo.setCode(form.getCode());
        bo.setCategoryTypeId(form.getCategoryTypeId());
        bo.setTheOrder(form.getTheOrder());
        bo.setName(form.getName());
        bo.setEffectDate(CommonUtil.convertStringToDate(form.getEffectDateShow()));
        bo.setExpiredDate(CommonUtil.convertStringToDate(form.getExpiredDateShow()));
       
        categoryService.saveOrUpdate(bo);
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSaveCategory");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
    public String actionDelete(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        CategoryBO bo = categoryService.findById(id);
        if(bo==null) {
            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
            req.setAttribute("message", "Bản ghi đã bị xóa!");
            return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
        }
        
        
        categoryService.delete(id);
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSaveCategory");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
}
