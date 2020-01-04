package application.tai.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import application.domain.DataTableResults;


@Controller
@RequestMapping(path = "/tai-nc")
public class taiNCController {
	
    private static String RESEARCH_PAGE ="researchPage";
    
    @RequestMapping
    public String researchPage(HttpServletRequest req, Model model) {
        return RESEARCH_PAGE;
    }
}
