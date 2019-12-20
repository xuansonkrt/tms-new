package application.category.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import application.category.bean.CategoryBean;
import application.category.bo.CategoryTypeBO;
import application.category.form.CategoryForm;
import application.category.service.CategoryService;
import application.category.service.CategoryTypeService;
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
}
