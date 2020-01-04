package application.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import application.common.CommonUtil;
import application.staff.bo.StaffBO;
import application.staff.service.StaffService;
import application.user.form.UserForm;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    
    
    @Autowired
    private StaffService staffService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    private static String LOGIN_PAGE="loginPage";
    private static String CHANGE_PASSWORD_PAGE="changePasswordPage";
    
    
    
    @RequestMapping("/login")
    public String login(HttpServletRequest req, Model model) {
        return LOGIN_PAGE;
    }
    
    @RequestMapping("/change-password")
    public String changePassword(HttpServletRequest req, Model model) {
        return CHANGE_PASSWORD_PAGE;
    }
    
    @PostMapping("/change-password")
    public String changePasswordPost(HttpServletRequest req, Model model, UserForm form ) {
        Long id= CommonUtil.getUserId(req);
        StaffBO bo = staffService.findById(CommonUtil.NVL(id));
        if(bo!=null) {
            if(passwordEncoder.matches(form.getPasswordOld(),bo.getPasswordHash()) == true) {
                bo.setPasswordHash(passwordEncoder.encode(form.getPasswordNew()));
                staffService.saveOrUpdate(bo);
                return "redirect:/user/change-password?success";
            }
            
            
        }
        return "redirect:/user/change-password?error";
    }
}
