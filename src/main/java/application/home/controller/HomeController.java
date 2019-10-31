package application.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
    private final static String HOME_PAGE = "homePage";
    private final static String DEMO_PAGE = "demoPage";
    
    @RequestMapping("/")
    public String home(Model model) {
        return HOME_PAGE;
    }
    
    @RequestMapping("/demo")
    public String demo(Model model) {
        return DEMO_PAGE;
    }
}
