package application.paperType.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import application.paperType.service.PaperTypeService;

@Controller
@RequestMapping("/paper-type")
public class PaperTypeController {
    @Autowired
    private PaperTypeService paperTypeService;
    
    private static String PAPERTYPE_PAGE ="paperTypePage";
    private static String PAPERTYPE_FORM ="paperTypeForm";
    private static String PAPERTYPE_LIST ="paperTypeList";
    
    @RequestMapping
    public String categoryPage(HttpServletRequest req, Model model) {
        return PAPERTYPE_PAGE;
    }
}
