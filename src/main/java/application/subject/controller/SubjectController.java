package application.subject.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
import application.subject.bean.SubjectBean;
import application.subject.bo.SubjectBO;
import application.subject.form.SubjectForm;
import application.subject.service.SubjectService;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    
    @Autowired
    private CategoryTypeService categoryTypeService;
    
    @Autowired
    private CategoryService categoryService;
    
    private static String SUBJECT_PAGE ="subjectPage";
    private static String SUBJECT_FORM ="subjectForm";
    private static String SUBJECT_LIST ="subjectList";
    
    @RequestMapping
    public String subjectPage(HttpServletRequest req, Model model) {
        List<CategoryBean> lstEducationLevel = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.EDU_LEVEL);
        req.setAttribute("lstEducationLevel", lstEducationLevel);
        return SUBJECT_PAGE;
    }
    
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String search(HttpServletRequest req, Model model, SubjectForm form) {
        DataTableResults<SubjectBean>  lstTerm= subjectService.searchData(form, req);
        req.setAttribute("resultList", lstTerm.getData());
        return SUBJECT_LIST;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String prepareAdd(HttpServletRequest req, Model model, SubjectForm form) {
        List<CategoryBean> lstEducationLevel = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.EDU_LEVEL);
        req.setAttribute("subject", new SubjectBO());
        req.setAttribute("lstEducationLevel",lstEducationLevel);
        return SUBJECT_FORM;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String prepareUpdate(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        SubjectBO bo = subjectService.findById(id);
        SubjectBean bean = new SubjectBean();
        CommonUtil.copyProperties(bean, bo);
        List<CategoryBean> lstEducationLevel = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.EDU_LEVEL);
        req.setAttribute("lstEducationLevel",lstEducationLevel);
        
        req.setAttribute("subject", bean);
        return SUBJECT_FORM;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String actionSave(HttpServletRequest req, Model model, SubjectForm form) throws Exception {
        Long id = CommonUtil.NVL(form.getId());
        
        SubjectBO bo;
        if(id>0L) {
            bo = subjectService.findById(id);
            bo.setModifiedBy(CommonUtil.getUserId(req));
            bo.setModifiedDate(new Date());
        } else {
            bo = new SubjectBO();
            bo.setCreatedBy(CommonUtil.getUserId(req));
            bo.setCreatedDate(new Date());
        }
        bo.setCode(form.getCode());
        bo.setName(form.getName());
        bo.setClassPeriod(form.getClassPeriod());
        bo.setCredit(form.getCredit());
        bo.setNote(form.getNote());
        bo.setOrganizationId(form.getOrganizationId());
        bo.setEducationLevelId(form.getEducationLevelId());
        
        subjectService.saveOrUpdate(bo);
        
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSave");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
    public String actionDelete(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        SubjectBO bo = subjectService.findById(id);
        if(bo==null) {
            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
            req.setAttribute("message", "Bản ghi đã bị xóa!");
            return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
        }
        
        subjectService.delete(id);
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSave");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
}
