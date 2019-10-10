package application.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import application.common.Response;
import application.demo.dao.CartDAO;

@RestController
@RequestMapping(path = "/api/cart")
public class CartAPIController {
    @Autowired
    private CartDAO cartDAO;
    
    @GetMapping("/demo")
    public @ResponseBody Response demo(Long index) {
        Response response = new Response();
        response.setStatus("OK");
        response.setData(cartDAO.getAll());
        return response;
    }
}
