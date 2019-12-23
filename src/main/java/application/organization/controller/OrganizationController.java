package application.organization.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import application.common.CommonUtil;
import application.common.ConverterJSON;
import application.common.Response;
import application.organization.bean.Node;
import application.organization.bean.TreeBean;
import application.organization.service.OrganizationService;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
    
    @Autowired
    private OrganizationService organizationService;
    
    private static String ORGANIZATION_PAGE ="organizationPage";
    
    @RequestMapping
    public String categoryPage(HttpServletRequest req, Model model) {
        return ORGANIZATION_PAGE;
    }
    
    @RequestMapping(value="/get-root",  produces = "application/json; charset=utf-8", method=RequestMethod.GET)
    @ResponseBody
    public  <T> String  getRoot(HttpServletRequest req, Model model) throws JsonProcessingException {
        List<TreeBean> lst = organizationService.getRootTree();
        List<Node> lstNode = new ArrayList<>();
        if(!CommonUtil.isNullOrEmpty(lst)) {
            for (TreeBean node : lst) {
                lstNode.add(new Node(node.getId().toString(),node.getParent()==null?"#":node.getParent().toString(),node.getText()));
            }
        }
        return ConverterJSON.toJsonToString(lstNode) ;
    }
    
    @RequestMapping(value="/get-children/{id}", produces = "application/json; charset=utf-8", method=RequestMethod.GET)
    @ResponseBody
    public  <T> String getChildren(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws JsonProcessingException {
        List<TreeBean> lst = organizationService.getChilrenNode(id);
        List<Node> lstNode = new ArrayList<>();
        if(!CommonUtil.isNullOrEmpty(lst)) {
            for (TreeBean node : lst) {
                lstNode.add(new Node(node.getId().toString(),node.getParent()==null?"#":node.getParent().toString(),node.getText()));
            }
        }
        return ConverterJSON.toJsonToString(lstNode) ;
    }
}
