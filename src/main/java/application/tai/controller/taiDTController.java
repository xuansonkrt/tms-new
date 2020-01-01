package application.tai.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/tai-dt")
public class taiDTController {
    
    private static String CARRIAGE_TEACH="carriageDTPage";
    
    @RequestMapping("/list")
    public String login(HttpServletRequest req, Model model) {
        return CARRIAGE_TEACH;
    }
}
