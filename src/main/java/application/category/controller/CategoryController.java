package application.category.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import application.category.bo.CategoryTypeBO;
import application.category.service.CategoryTypeService;

@Controller
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    private CategoryTypeService categoryService;
    private static String CATEGORY_PAGE ="categoryPage";
    
    
    @RequestMapping
    public String categoryPage(HttpServletRequest req, Model model) {
        List<CategoryTypeBO> lstCategoryType= categoryService.findAll();
        req.setAttribute("lstCategoryType", lstCategoryType);
        return CATEGORY_PAGE;
    }
}
