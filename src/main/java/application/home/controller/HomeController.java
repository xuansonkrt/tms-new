package application.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
    private final static String HOME_PAGE = "homePage";
    private final static String DEMO_PAGE = "demoPage";
    private final static String DASHBOARD_PAGE = "dashboardPage";
    private final static String DASHBOARD_VIEW = "dashboardView";
    
    @RequestMapping("/")
    public String home(Model model) {
        return HOME_PAGE;
    }
    
    @RequestMapping("/dashboard")
    public String dashboard(HttpServletRequest req, Model model) {
        req.setAttribute("schoolName", "Học viện Kỹ thuật Quân sự");
        return DASHBOARD_PAGE;
    }
    
    @RequestMapping("/demo")
    public String demo(HttpServletRequest req, Model model) {
        req.setAttribute("schoolName", "Học viện Kỹ thuật Quân sự");
        return DASHBOARD_VIEW;
    }
}
