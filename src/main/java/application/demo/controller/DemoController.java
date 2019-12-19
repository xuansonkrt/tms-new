package application.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import application.demo.bo.CartBO;
import application.demo.bo.HocLop;
import application.demo.dao.CartDAO;
import application.demo.dao.HocLopDAO;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private CartDAO cartDAO;
    
    
    @Autowired
    private HocLopDAO hoclopDAO;
    
    @RequestMapping("/sonnx")
    public String getAll() {
        List<CartBO> lst = cartDAO.getAll();
        return "a";
    }
    
    @GetMapping("/demo")
    public String getAllController(HttpServletRequest req) {
        List<HocLop> lst = hoclopDAO.findAll();
        HocLop a = hoclopDAO.findFirstByOrderByIdAsc();
        req.setAttribute("top1", a);
        req.setAttribute("list", lst);
        return "homePageDemo";
    }
}


