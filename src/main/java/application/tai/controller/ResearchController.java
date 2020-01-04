package application.tai.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import application.category.bean.CategoryBean;
import application.category.service.CategoryService;
import application.common.CommonUtil;
import application.common.Constants;
import application.course.bean.CourseBean;
import application.course.service.CourseService;
import application.domain.DataTableResults;
import application.learningType.bean.LearningTypeBean;
import application.learningType.service.LearningTypeService;
import application.paperType.bo.PaperTypeBO;
import application.paperType.service.PaperTypeService;
import application.staff.bean.StaffBean;
import application.staff.bo.StaffBO;
import application.staff.form.StaffForm;
import application.staff.service.StaffService;
import application.tai.bean.StaffCourseBean;
import application.tai.bean.StaffPaperBean;
import application.tai.bo.StaffCourseBO;
import application.tai.bo.StaffPaperBO;
import application.tai.form.StaffCourseForm;
import application.tai.form.StaffPaperForm;
import application.tai.service.StaffCourseService;
import application.tai.service.StaffPaperService;
import application.term.bean.TermBean;
import application.term.service.TermService;

@Controller
@RequestMapping(path = "/research")
public class ResearchController {
    @Autowired
    private StaffService staffService;
    
    @Autowired
    private TermService termService;
    
    @Autowired
    private StaffPaperService staffPaperService;
    
    
    @Autowired
    private StaffCourseService staffCourseService;
    
    @Autowired
    private PaperTypeService paperTypeService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private LearningTypeService learningTypeService;
    
    private static String RESEARCH_PAGE ="researchPage";
    private static String STAFF_INFO ="staffInfo";
    private static String STAFF_PAPER_LIST ="staffPaperList";
    private static String STAFF_PAPER_FORM ="staffPaperForm";
    private static String STAFF_COURSE_FORM ="staffCourseForm";
    private static String STAFF_COURSE_LIST ="staffCourseList";
    
    @RequestMapping
    public String researchPage(HttpServletRequest req, Model model) {
        Long currentId = CommonUtil.getUserId(req);
        StaffBO bo = staffService.findById(currentId);
        List<StaffBean> lstStaff = staffService.getStaffOrg(bo.getOrganizationId());
        StaffBean staffBean = staffService.staffInfo(currentId);
        
        req.setAttribute("lstStaff", lstStaff);
        req.setAttribute("staffBean", staffBean);
        return RESEARCH_PAGE;
    }
    
    @GetMapping(value="/staff/{id}")
    public String getStaffInfo(HttpServletRequest req, Model model, @PathVariable("id") Long id) {
        StaffBean staffBean = staffService.staffInfo(id);
        List<StaffBean> lstStaff = staffService.getStaffOrg(staffBean.getOrganizationId());
        
        req.setAttribute("lstStaff", lstStaff);
        req.setAttribute("staffBean", staffBean);
        return STAFF_INFO;
    }
    
    @GetMapping(value="/staff-paper")
    public String searchStaffPaper(HttpServletRequest req, Model model,StaffPaperForm form) {
        DataTableResults<StaffPaperBean>  lstTerm= staffPaperService.searchData(form, req);
        req.setAttribute("resultList", lstTerm.getData());
        return STAFF_PAPER_LIST;
    }
    
    @GetMapping(value="/staff-course")
    public String searchStaffCourse(HttpServletRequest req, Model model,StaffCourseForm form) {
        DataTableResults<StaffCourseBean>  lstTerm= staffCourseService.searchData(form, req);
        req.setAttribute("resultList", lstTerm.getData());
        return STAFF_COURSE_LIST;
    }
    
    
    @RequestMapping(value="/staff-paper/add/{id}", method=RequestMethod.GET)
    public String prepareAdd(HttpServletRequest req, Model model, StaffForm form, @PathVariable("id") Long id) {
        StaffPaperForm staffPaperForm = new StaffPaperForm();
        staffPaperForm.setStaffId(id);
        
        List<PaperTypeBO> lstPaperType = paperTypeService.findAll();
        
        req.setAttribute("staffPaper", staffPaperForm);
        req.setAttribute("lstPaperType", lstPaperType);
        return STAFF_PAPER_FORM;
    }
    
    
    @RequestMapping(value="/staff-course/add/{id}", method=RequestMethod.GET)
    public String prepareAddStaffCourse(HttpServletRequest req, Model model, StaffForm form, @PathVariable("id") Long id) {
        StaffCourseForm staffCourseForm = new StaffCourseForm();
        staffCourseForm.setStaffId(id);
        
        List<CategoryBean> lstEducationLevel = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.EDU_LEVEL);
        List<CourseBean> lstCourse = courseService.getByEducationLevel(null);
        List<LearningTypeBean> lstLearningType = learningTypeService.getByEducationLevel(null);
        
        req.setAttribute("staffCourse", staffCourseForm);
        req.setAttribute("lstEducationLevel", lstEducationLevel);
        req.setAttribute("lstCourse", lstCourse);
        req.setAttribute("lstLearningType", lstLearningType);
        return STAFF_COURSE_FORM;
    }
    
    @RequestMapping(value="/get-course/{educationLevelId}", method=RequestMethod.GET)
    public String getCourseByEducationLevel(HttpServletRequest req, Model model, @PathVariable("educationLevelId") Long educationLevelId) {
        List<CourseBean> lstCourse = courseService.getByEducationLevel(educationLevelId);
        req.setAttribute("lstCourse", lstCourse);
        return "courseCombobox";
    }
    
    @RequestMapping(value="/get-learning-type/{educationLevelId}", method=RequestMethod.GET)
    public String getLearningTypeByEducationLevel(HttpServletRequest req, Model model, @PathVariable("educationLevelId") Long educationLevelId) {
        List<LearningTypeBean> lstLearningType = learningTypeService.getByEducationLevel(educationLevelId);
        req.setAttribute("lstLearningType", lstLearningType);
        return "learningTypeCombobox";
    }
    
    
    @RequestMapping(value="/staff-paper/{id}", method=RequestMethod.GET)
    public String prepareUpdate(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        StaffPaperBO bo = staffPaperService.findById(id);
        StaffPaperBean bean = new StaffPaperBean();
        CommonUtil.copyProperties(bean, bo);
        bean.setPublishDateString(CommonUtil.convertDateToString(bo.getPublishDate()));
        List<PaperTypeBO> lstPaperType = paperTypeService.findAll();
        
        req.setAttribute("staffPaper", bean);
        req.setAttribute("lstPaperType", lstPaperType);
        return STAFF_PAPER_FORM;
    }
    
    @RequestMapping(value="/staff-course/{id}", method=RequestMethod.GET)
    public String prepareUpdateStaffCourse(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        StaffCourseBO bo = staffCourseService.findById(id);
        StaffCourseBean bean = new StaffCourseBean();
        CommonUtil.copyProperties(bean, bo);
        bean.setFinishDateShow(CommonUtil.convertDateToString(bo.getFinishDate()));
        
        req.setAttribute("staffCourse", bean);
        List<CategoryBean> lstEducationLevel = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.EDU_LEVEL);
        List<CourseBean> lstCourse = courseService.getByEducationLevel(null);
        List<LearningTypeBean> lstLearningType = learningTypeService.getByEducationLevel(null);
        
        req.setAttribute("lstEducationLevel", lstEducationLevel);
        req.setAttribute("lstCourse", lstCourse);
        req.setAttribute("lstLearningType", lstLearningType);
        return STAFF_COURSE_FORM;
    }
    
    @RequestMapping(value="/staff-paper",method=RequestMethod.POST)
    public String actionSave(HttpServletRequest req, Model model, StaffPaperForm form) throws Exception {
        Long id = CommonUtil.NVL(form.getId());
        
        StaffPaperBO bo;
        if(id>0L) {
            bo = staffPaperService.findById(id);
            bo.setModifiedBy(CommonUtil.getUserId(req));
            bo.setModifiedDate(new Date());
            
            StaffBO staffBO = staffService.findById(form.getStaffId());
            if(staffBO!=null) {
                bo.setOrganizationId(staffBO.getOrganizationId());
            }
        } else {
            bo = new StaffPaperBO();
            bo.setCreatedBy(CommonUtil.getUserId(req));
            bo.setCreatedDate(new Date());
        }
        bo.setCode(form.getCode());
        bo.setName(form.getName());
        bo.setAuthor(form.getAuthor());
        bo.setNumberAuthor(form.getNumberAuthor());
        bo.setStaffId(form.getStaffId());
        bo.setResearchPoint(form.getResearchPoint());
        bo.setPaperTypeId(form.getPaperTypeId());
        bo.setPublishDate(CommonUtil.convertStringToDate(form.getPublishDateString()));
        List<TermBean> lst = termService.getTermByDate(bo.getPublishDate());
        if(CommonUtil.isNullOrEmpty(lst)) {
            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
            req.setAttribute("message", "Ngày xuất bản không hợp lệ!");
            return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
        }
        bo.setTerm(lst.get(0).getTheOrder());
        bo.setYear(lst.get(0).getYear());
        staffPaperService.saveOrUpdate(bo);
        
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSave");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
    
    
    @RequestMapping(value="/staff-course",method=RequestMethod.POST)
    public String actionSaveStaffCourse(HttpServletRequest req, Model model, StaffCourseForm form) throws Exception {
        Long id = CommonUtil.NVL(form.getId());
        
        StaffCourseBO bo;
        if(id>0L) {
            bo = staffCourseService.findById(id);
            bo.setModifiedBy(CommonUtil.getUserId(req));
            bo.setModifiedDate(new Date());
            
            StaffBO staffBO = staffService.findById(form.getStaffId());
            if(staffBO!=null) {
                bo.setOrganizationId(staffBO.getOrganizationId());
            }
        } else {
            bo = new StaffCourseBO();
            bo.setCreatedBy(CommonUtil.getUserId(req));
            bo.setCreatedDate(new Date());
        }
        bo.setStaffId(form.getStaffId());
        bo.setCourseId(form.getCourseId());
        bo.setEducationLevelId(form.getEducationLevelId());
        bo.setLearningTypeId(form.getLearningTypeId());
        bo.setAmount(form.getAmount());
        bo.setEduPoint(form.getEduPoint());
        bo.setFinishDate(CommonUtil.convertStringToDate(form.getFinishDateShow()));
        List<TermBean> lst = termService.getTermByDate(bo.getFinishDate());
        if(CommonUtil.isNullOrEmpty(lst)) {
            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
            req.setAttribute("message", "Ngày xuất bản không hợp lệ!");
            return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
        }
        bo.setTerm(lst.get(0).getTheOrder());
        bo.setYear(lst.get(0).getYear());
        staffCourseService.saveOrUpdate(bo);
        
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSaveCourse");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
    
    @RequestMapping(value="/staff-paper/delete/{id}", method=RequestMethod.POST)
    public String actionDelete(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        StaffPaperBO bo = staffPaperService.findById(id);
        if(bo==null) {
            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
            req.setAttribute("message", "Bản ghi đã bị xóa!");
            return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
        }
        
        staffPaperService.delete(id);
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSave");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
    
    @RequestMapping(value="/staff-course/delete/{id}", method=RequestMethod.POST)
    public String actionDeleteStaffCourse(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        StaffCourseBO bo = staffCourseService.findById(id);
        if(bo==null) {
            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
            req.setAttribute("message", "Bản ghi đã bị xóa!");
            return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
        }
        
        staffCourseService.delete(id);
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSaveCourse");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
}
