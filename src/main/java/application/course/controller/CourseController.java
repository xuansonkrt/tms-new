package application.course.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import application.category.service.CategoryService;
import application.category.service.CategoryTypeService;
import application.course.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private CategoryTypeService categoryTypeService;
    
    @Autowired
    private CategoryService categoryService;
    
    private static String COURSE_PAGE ="coursePage";
    private static String COURSE_FORM ="courseForm";
    private static String COURSE_LIST ="courseList";
    
    @RequestMapping
    public String coursePage(HttpServletRequest req, Model model) {
        return COURSE_PAGE;
    }
//    
//    @RequestMapping(value="/search", method=RequestMethod.GET)
//    public String search(HttpServletRequest req, Model model, TermForm form) {
//        req.setAttribute("lstcourse", courseService.getAll());
//        return course_LIST;
//    }
//    
//    @RequestMapping(value="/add", method=RequestMethod.GET)
//    public String prepareAdd(HttpServletRequest req, Model model, courseForm form) {
//        List<CategoryTypeBO> lstCategoryType = categoryTypeService.findAll();
//        List<CategoryBean> lstCategory = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.CDNG);
//        CategoryTypeBO categoryTypeBO = categoryTypeService.findOneByCodeIgnoreCase(Constants.CATEGORY_TYPE.CDNG);
//        categoryTypeBO = categoryTypeBO==null? new CategoryTypeBO() : categoryTypeBO;
//        
//        req.setAttribute("course", new courseBO());
//        req.setAttribute("lstCategory", lstCategory);
//        req.setAttribute("lstCategoryType",lstCategoryType);
//        req.setAttribute("categoryTypeBO",categoryTypeBO);
//        return course_FORM;
//    }
//    
//    @RequestMapping(value="/{id}", method=RequestMethod.GET)
//    public String prepareUpdate(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
//        courseBO bo = courseService.findById(id);
//        courseBean bean = new courseBean();
//        CommonUtil.copyProperties(bean, bo);
//        List<CategoryTypeBO> lstCategoryType = categoryTypeService.findAll();
//        List<CategoryBean> lstCategory = categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.CDNG);
//        CategoryTypeBO categoryTypeBO = categoryTypeService.findOneByCodeIgnoreCase(Constants.CATEGORY_TYPE.CDNG);
//        categoryTypeBO = categoryTypeBO==null? new CategoryTypeBO() : categoryTypeBO;
//        
//        req.setAttribute("course", bean);
//        req.setAttribute("lstCategory", lstCategory);
//        req.setAttribute("lstCategoryType",lstCategoryType);
//        req.setAttribute("categoryTypeBO",categoryTypeBO);
//        return course_FORM;
//    }
//    
//    @RequestMapping(method=RequestMethod.POST)
//    public String actionSave(HttpServletRequest req, Model model, courseForm form) throws Exception {
//        Long id = CommonUtil.NVL(form.getId());
//        
//        /*
//         * if(termService.checkCode(id, form.getCode())) {
//         * req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
//         * req.setAttribute("message", "Mã loại danh mục đã tồn tại!");
//         * return UPDATE_AND_CLOSE;
//         * }
//         */
//        if(courseService.isDuplicate(form.getTheType(), form.getStaffPropertyId())) {
//            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
//            req.setAttribute("message", "Đã nhập định mức cho chức danh");
//            return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
//        }
//        
//        courseBO bo;
//        if(id>0L) {
//            bo = courseService.findById(id);
//            bo.setModifiedBy(CommonUtil.getUserId(req));
//            bo.setModifiedDate(new Date());
//        } else {
//            bo = new courseBO();
//            bo.setCreatedBy(CommonUtil.getUserId(req));
//            bo.setCreatedDate(new Date());
//        }
//        bo.setTheType(form.getTheType());
//        bo.setStaffPropertyId(form.getStaffPropertyId());
//        bo.setEduDuty(form.getEduDuty());
//        bo.setResearchDuty(form.getResearchDuty());
//        
//        courseService.saveOrUpdate(bo);
//        
//        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
//        req.setAttribute("callback", "afterSave");
//        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
//    }
//    
//    @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
//    public String actionDelete(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
//        courseBO bo = courseService.findById(id);
//        if(bo==null) {
//            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
//            req.setAttribute("message", "Bản ghi đã bị xóa!");
//            return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
//        }
//        
//        
//        courseService.delete(id);
//        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
//        req.setAttribute("callback", "afterSave");
//        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
//    }
}
