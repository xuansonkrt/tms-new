package application.category.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import application.category.bo.CategoryTypeBO;
import application.category.form.CategoryTypeForm;
import application.category.service.CategoryTypeService;
import application.common.CommonUtil;

@Controller
@RequestMapping("/category-type")
public class CategoryTypeController {

    @Autowired
    private CategoryTypeService categoryTypeService;
    
    private static String CATEGORY_TYPE_FORM ="categoryTypeAdd";
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String prepareAdd(HttpServletRequest req, Model model) {
        req.setAttribute("categoryType", new CategoryTypeForm());
        return CATEGORY_TYPE_FORM;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String prepareUpdate(HttpServletRequest req, Model model, @PathVariable("id") Long id) {
        CategoryTypeBO categoryTypeBO = categoryTypeService.findById(id);
        req.setAttribute("categoryType", categoryTypeBO);
        return CATEGORY_TYPE_FORM;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String actionSave(HttpServletRequest req, Model model, CategoryTypeForm form) throws Exception {
        Long id = CommonUtil.NVL(form.getId());
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
        bo.setEffectDate(CommonUtil.convertStringToDate(form.getEffectDate()));
        bo.setExpiredDate(CommonUtil.convertStringToDate(form.getExpiredDate()));
       
        categoryTypeService.saveOrUpdate(bo);
        req.setAttribute("categoryType", new CategoryTypeForm());
        return CATEGORY_TYPE_FORM;
    }
}
