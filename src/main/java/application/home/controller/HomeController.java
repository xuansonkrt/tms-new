package application.home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import application.staff.bo.StaffBO;
import application.staff.service.StaffService;

@Controller

public class HomeController {
    @Autowired
    private StaffService staffService;
    
    private final static String HOME_PAGE = "homePage";
    private final static String DEMO_PAGE = "demoPage";
    private final static String DASHBOARD_PAGE = "dashboardPage";
    private final static String DASHBOARD_VIEW = "dashboardView";
    
    @RequestMapping("/")
    public String home(HttpServletRequest req, Model model) {
        String  username = SecurityContextHolder.getContext().getAuthentication().getName();
        StaffBO bo = staffService.findUserByUsername(username);
        HttpSession session = req.getSession();
        session.setAttribute("name", bo.getName());
        session.setAttribute("avatar", bo.getAvatar());
        session.setAttribute("userId", bo.getId());
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
