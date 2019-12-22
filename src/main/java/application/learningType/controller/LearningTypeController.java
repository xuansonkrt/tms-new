package application.learningType.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import application.category.service.CategoryService;
import application.common.CommonUtil;
import application.common.Constants;
import application.domain.DataTableResults;
import application.learningType.bean.LearningTypeBean;
import application.learningType.bo.LearningTypeBO;
import application.learningType.form.LearningTypeForm;
import application.learningType.service.LearningTypeService;
import application.term.bean.TermBean;
import application.term.bo.TermBO;

@Controller
@RequestMapping("/learning-type")
public class LearningTypeController {
    @Autowired
    private LearningTypeService learningTypeService;
    
    
    @Autowired
    private CategoryService categoryService;
    
    private static String LEARNINGTYPE_PAGE ="learningTypePage";
    private static String LEARNINGTYPE_FORM ="learningTypeForm";
    private static String LEARNINGTYPE_LIST ="learningTypeList";
    
    @RequestMapping
    public String categoryPage(HttpServletRequest req, Model model) {
        req.setAttribute("lstEducationLevel", categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.EDU_LEVEL));
        return LEARNINGTYPE_PAGE;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String prepareAdd(HttpServletRequest req, Model model, LearningTypeForm form) {
        
        req.setAttribute("learningType", new LearningTypeBO());
        req.setAttribute("lstEducationLevel", categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.EDU_LEVEL));
        return LEARNINGTYPE_FORM;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String actionSave(HttpServletRequest req, Model model, LearningTypeForm form) throws Exception {
        Long id = CommonUtil.NVL(form.getId());
        
        /*
         * if(termService.checkCode(id, form.getCode())) {
         * req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
         * req.setAttribute("message", "Mã loại danh mục đã tồn tại!");
         * return UPDATE_AND_CLOSE;
         * }
         */
        
        LearningTypeBO bo;
        if(id>0L) {
            bo = learningTypeService.findById(id);
            bo.setModifiedBy(CommonUtil.getUserId(req));
            bo.setModifiedDate(new Date());
        } else {
            bo = new LearningTypeBO();
            bo.setCreatedBy(CommonUtil.getUserId(req));
            bo.setCreatedDate(new Date());
        }
        
        bo.setCode(form.getCode());
        bo.setName(form.getName());
        bo.setEducationLevelId(form.getEducationLevelId());
        bo.setFactor(form.getFactor());
        bo.setUnit(form.getUnit());
        bo.setUnitName(form.getUnitName());
        bo.setNote(form.getNote());
        
        learningTypeService.saveOrUpdate(bo);
        
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSave");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
    
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String search(HttpServletRequest req, Model model, LearningTypeForm form) {
        DataTableResults<LearningTypeBean>  lstTerm= learningTypeService.searchData(form, req);
        req.setAttribute("resultList", lstTerm.getData());
        return LEARNINGTYPE_LIST;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String prepareUpdate(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        LearningTypeBO bo = learningTypeService.findById(id);
        LearningTypeBean bean = new LearningTypeBean();
        CommonUtil.copyProperties(bean, bo);
        req.setAttribute("learningType", bean);
        req.setAttribute("lstEducationLevel", categoryService.getByCategoryTypeCode(Constants.CATEGORY_TYPE.EDU_LEVEL));
        return LEARNINGTYPE_FORM;
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
    public String actionDelete(HttpServletRequest req, Model model, @PathVariable("id") Long id) throws Exception {
        LearningTypeBO bo = learningTypeService.findById(id);
        if(bo==null) {
            req.setAttribute("status", Constants.RESPONSE_CODE.ERROR);
            req.setAttribute("message", "Bản ghi đã bị xóa!");
            return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
        }
        
        
        learningTypeService.delete(id);
        req.setAttribute("status", Constants.RESPONSE_CODE.SUCCESS);
        req.setAttribute("callback", "afterSave");
        return Constants.RESPONSE_PAGE.UPDATE_AND_CLOSE;
    }
}
