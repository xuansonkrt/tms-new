package application.course.controller;

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
import application.category.bo.CategoryTypeBO;
import application.category.service.CategoryService;
import application.category.service.CategoryTypeService;
import application.common.CommonUtil;
import application.common.Constants;
import application.course.bean.CourseBean;
import application.course.bo.CourseBO;
import application.course.form.CourseForm;
import application.course.service.CourseService;
import application.domain.DataTableResults;
import application.learningType.bean.LearningTypeBean;
import application.subject.bean.SubjectBean;
import application.subject.service.SubjectService;
import application.term.bean.TermBean;
import application.term.service.TermService;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private CategoryTypeService categoryTypeService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private TermService termService;
    
    @Autowired
    private SubjectService subjectService;
    
    private static String COURSE_PAGE ="coursePage";
    private static String COURSE_FORM ="courseForm";
    private static String COURSE_LIST ="courseList";
    
    @RequestMapping
    public String coursePage(HttpServletRequest req, Model model) {
        List<CategoryBean> lstEducationLevel = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.EDU_LEVEL);
        List<TermBean> lstTerm = termService.getAllCombobox();
        List<SubjectBean> lstSubject = subjectService.getAllOrderByNameAsc();
        req.setAttribute("lstSubject", lstSubject);
        req.setAttribute("lstTerm", lstTerm);
        req.setAttribute("lstEducationLevel", lstEducationLevel);
        return COURSE_PAGE;
    }
    
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String search(HttpServletRequest req, Model model, CourseForm form) {
        DataTableResults<CourseBean>  lst= courseService.searchData(form, req);
        req.setAttribute("resultList", lst.getData());
        return COURSE_LIST;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String prepareAdd(HttpServletRequest req, Model model, CourseForm form) {
        List<CategoryTypeBO> lstCategoryType = categoryTypeService.findAll();
        
        List<TermBean> lstTerm = termService.getAllCombobox();
        List<SubjectBean> lstSubject = subjectService.getAllOrderByNameAsc();
        List<CategoryBean> lstEducationLevel = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.EDU_LEVEL);
        
        req.setAttribute("lstCategoryType",lstCategoryType);
        CourseForm vm = new CourseForm();
        if(!CommonUtil.isNullOrEmpty(lstTerm)) {
            vm.setTermId(lstTerm.get(0).getId());
        }
        req.setAttribute("course", vm);
        req.setAttribute("lstTerm", lstTerm);
        req.setAttribute("lstSubject", lstSubject);
        req.setAttribute("lstEducationLevel", lstEducationLevel);
        return COURSE_FORM;
    }
    
    @RequestMapping(value="/get-subject/{educationLevelId}", method=RequestMethod.GET)
    public String getSubjectByEducationLevel(HttpServletRequest req, Model model, @PathVariable("educationLevelId") Long educationLevelId) {
        List<SubjectBean> lstSubject = subjectService.getAllByEducationLevelOrderByNameAsc(educationLevelId);
        req.setAttribute("lstSubject", lstSubject);
        return "subjectCombobox";
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String prepareUpdate(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        CourseBO bo = courseService.findById(id);
        CourseBean bean = new CourseBean();
        CommonUtil.copyProperties(bean, bo);
        
        List<TermBean> lstTerm = termService.getAllCombobox();
        List<SubjectBean> lstSubject = subjectService.getAllOrderByNameAsc();
        List<CategoryBean> lstEducationLevel = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.EDU_LEVEL);
        req.setAttribute("lstTerm", lstTerm);
        req.setAttribute("lstSubject", lstSubject);
        req.setAttribute("lstEducationLevel", lstEducationLevel);

        req.setAttribute("course", bean);
        return COURSE_FORM;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String actionSave(HttpServletRequest req, Model model, CourseForm form) throws Exception {
        Long id = CommonUtil.NVL(form.getId());
        
        /*
         * if(termService.checkCode(id, form.getCode())) {
         * req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
         * req.setAttribute("message", "Mã loại danh mục đã tồn tại!");
         * return UPDATE_AND_CLOSE;
         * }
         */

        
        CourseBO bo;
        if(id>0L) {
            bo = courseService.findById(id);
            bo.setModifiedBy(CommonUtil.getUserId(req));
            bo.setModifiedDate(new Date());
        } else {
            bo = new CourseBO();
            bo.setCreatedBy(CommonUtil.getUserId(req));
            bo.setCreatedDate(new Date());
        }
        bo.setEducationLevelId(form.getEducationLevelId());
        bo.setSubjectId(form.getSubjectId());
        bo.setCode(form.getCode());
        bo.setName(form.getName());
        bo.setTermId(form.getTermId());
        bo.setStudentAmount(form.getStudentAmount());
        
        courseService.saveOrUpdate(bo);
        
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSave");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
    public String actionDelete(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        CourseBO bo = courseService.findById(id);
        if(bo==null) {
            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
            req.setAttribute("message", "Bản ghi đã bị xóa!");
            return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
        }
        
        
        courseService.delete(id);
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSave");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
}
