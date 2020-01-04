package application.staff.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import application.category.bean.CategoryBean;
import application.category.service.CategoryService;
import application.category.service.CategoryTypeService;
import application.common.CommonUtil;
import application.common.Constants;
import application.domain.DataTableResults;
import application.role.bo.StaffRoleBO;
import application.role.service.StaffRoleService;
import application.staff.bean.StaffBean;
import application.staff.bo.StaffBO;
import application.staff.form.StaffForm;
import application.staff.service.StaffService;

@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    
    @Autowired
    private CategoryTypeService categoryTypeService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private StaffRoleService staffRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    private static String STAFF_PAGE ="staffPage";
    private static String STAFF_FORM ="staffForm";
    private static String STAFF_LIST ="staffList";
    
    @RequestMapping
    public String StaffPage(HttpServletRequest req, Model model) {
        
        return STAFF_PAGE;
    }
    
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String search(HttpServletRequest req, Model model, StaffForm form) {
        DataTableResults<StaffBean>  lstStaff= staffService.searchData(form, req);
        req.setAttribute("resultList", lstStaff.getData());
        return STAFF_LIST;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String prepareAdd(HttpServletRequest req, Model model, StaffForm form) {
        List<CategoryBean> lstAcademicLevel = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.HOC_VI);
        List<CategoryBean> lstAcademicTitle = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.HOC_HAM);
        List<CategoryBean> lstArmyRank = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.CAP_BAC);
        List<CategoryBean> lstLevelTitle = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.CDNG);
        
        req.setAttribute("lstAcademicLevel", lstAcademicLevel);
        req.setAttribute("lstAcademicTitle", lstAcademicTitle);
        req.setAttribute("lstArmyRank", lstArmyRank);
        req.setAttribute("lstLevelTitle", lstLevelTitle);
        StaffForm vm = new StaffForm();
        vm.setAvatar("/link/avatar.png");
        req.setAttribute("staff", vm);
        return STAFF_FORM;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String prepareUpdate(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        StaffBO bo = staffService.findById(id);
        StaffBean bean = new StaffBean();
        CommonUtil.copyProperties(bean, bo);
        List<CategoryBean> lstAcademicLevel = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.HOC_VI);
        List<CategoryBean> lstAcademicTitle = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.HOC_HAM);
        List<CategoryBean> lstArmyRank = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.CAP_BAC);
        List<CategoryBean> lstLevelTitle = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.CDNG);
        
        req.setAttribute("lstAcademicLevel", lstAcademicLevel);
        req.setAttribute("lstAcademicTitle", lstAcademicTitle);
        req.setAttribute("lstArmyRank", lstArmyRank);
        req.setAttribute("lstLevelTitle", lstLevelTitle);
        bean.setDateOfBirthShow(CommonUtil.convertDateToString(bo.getDateOfBirth()));
        req.setAttribute("staff", bean);
        return STAFF_FORM;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String actionSave(HttpServletRequest req, Model model, StaffForm form) throws Exception {
        Long id = CommonUtil.NVL(form.getId());
        boolean isNew = false;
        //check trungg user name
        StaffBO bo;
        if(id>0L) {
            bo = staffService.findById(id);
            bo.setModifiedBy(CommonUtil.getUserId(req));
            bo.setModifiedDate(new Date());
            
        } else {
            bo = new StaffBO();
            bo.setCreatedBy(CommonUtil.getUserId(req));
            bo.setCreatedDate(new Date());
            bo.setPasswordHash(passwordEncoder.encode(form.getPassword()));
            isNew = true;
        }
        bo.setUserName(form.getUserName());
        bo.setCode(form.getCode());
        bo.setName(form.getName());
        bo.setOrganizationId(form.getOrganizationId());
        bo.setAcademicLevelId(form.getAcademicLevelId());
        bo.setAcademicTitleId(form.getAcademicTitleId());
        bo.setArmyRankId(form.getArmyRankId());
        bo.setEmail(form.getEmail());
        bo.setPhoneNumber(form.getPhoneNumber());
        bo.setAddress(form.getAddress());
        bo.setGender(form.getGender());
        bo.setLevelTitleId(form.getLevelTitleId());
        bo.setDateOfBirth(CommonUtil.convertStringToDate(form.getDateOfBirthShow()));
        
        if(CommonUtil.isNullOrEmpty(form.getAvatar())) {
            bo.setAvatar("/link/avatar.png");
        } else {
            bo.setAvatar(form.getAvatar());
        }
        staffService.saveOrUpdate(bo);
        
        
        if(isNew) {
            StaffRoleBO staffRoleBO = new StaffRoleBO();
            staffRoleBO.setStaffId(bo.getId());
            staffRoleBO.setRoleId(2L);
            staffRoleService.saveOrUpdate(staffRoleBO);
        }
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSave");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
    public String actionDelete(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        StaffBO bo = staffService.findById(id);
        if(bo==null) {
            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
            req.setAttribute("message", "Bản ghi đã bị xóa!");
            return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
        }
        
        staffService.delete(id);
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSave");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
}
