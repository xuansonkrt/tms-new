package application.tai.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import application.common.CommonUtil;
import application.domain.DataTableResults;
import application.organization.bean.OrganizationBean;
import application.organization.bean.TreeBean;
import application.organization.form.OrganizationForm;
import application.organization.service.OrganizationService;
import application.paperType.service.PaperTypeService;
import application.staff.bean.StaffBean;
import application.staff.bo.StaffBO;
import application.staff.service.StaffService;
import application.tai.bean.taiTKBean;
import application.tai.form.taiDTForm;
import application.tai.service.StaffPaperService;
import application.term.service.TermService;

@Controller
@RequestMapping(path = "/bao-cao")
public class taiDTController {
    @Autowired
    private StaffService staffService;
    
    @Autowired
    private TermService termService;
    
    @Autowired
    private StaffPaperService staffPaperService;
    
    
    @Autowired
    private OrganizationService organizationService;
    
    private static String CARRIAGE="statisticalPage";
    private static String CARRIAGE_LIST="statisticalList";
    
    @RequestMapping
    public String researchPage(HttpServletRequest req, Model model) {
        return CARRIAGE;
    }
    
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String search(HttpServletRequest req, Model model, taiDTForm form) {
        List<taiTKBean>  lstTerm= staffService.getStaffCarriagebyListOrg(form.getParentId());
        
        req.setAttribute("resultList",lstTerm);
        return CARRIAGE_LIST;
    }
    
}
