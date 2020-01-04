package application.learningType.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import application.common.UttData;
import application.domain.DataTableResults;
import application.learningType.bean.LearningTypeBean;
import application.learningType.bo.LearningTypeBO;
import application.learningType.dao.LearningTypeDAO;
import application.learningType.form.LearningTypeForm;

@Service
public class LearningTypeService {
    @Autowired
    private UttData uttData;
    
    @Autowired
    private LearningTypeDAO learningTypeDAO;
    
    public void saveOrUpdate(LearningTypeBO entity) {
        learningTypeDAO.save(entity);
    }
    
    public LearningTypeBO findById(Long id) {
        return learningTypeDAO.findById(id).orElse(null);
    }
    
    @Modifying
    public void delete(Long categoryId) {
        learningTypeDAO.deleteById(categoryId);
    }
    
    public List<LearningTypeBO> findAll(){
        return learningTypeDAO.findAll();
    }
    
    public DataTableResults<LearningTypeBean> searchData(LearningTypeForm form, HttpServletRequest req) {
        return learningTypeDAO.searchData(uttData, form, req);
    }
    
    public List<LearningTypeBean> getByEducationLevel(Long educationLevelId) {
        return learningTypeDAO.getByEducationLevel(uttData, educationLevelId);
    }
}
