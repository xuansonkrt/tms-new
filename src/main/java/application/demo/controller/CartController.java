package application.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import application.demo.bo.CartBO;
import application.demo.dao.CartDAO;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartDAO cartDAO;
    
    
    @RequestMapping
    public String getAll() {
        List<CartBO> lst = cartDAO.getAll();
        return "a";
    }
}
