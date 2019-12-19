package application.category.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private static String CATEGORY_PAGE ="categoryPage";
    @RequestMapping
    public String categoryPage(HttpServletRequest req, Model model) {
        return CATEGORY_PAGE;
    }
}
