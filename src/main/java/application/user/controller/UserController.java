package application.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    
    private static String LOGIN_PAGE="loginPage";
    
    @RequestMapping("/login")
    public String login(HttpServletRequest req, Model model) {
        return LOGIN_PAGE;
    }
}
