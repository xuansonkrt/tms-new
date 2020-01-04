package application.course.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import application.common.UttData;
import application.course.bean.CourseBean;
import application.course.bo.CourseBO;
import application.course.dao.CourseDAO;
import application.course.form.CourseForm;
import application.domain.DataTableResults;

@Service
public class CourseService {
    
    @Autowired
    private UttData uttData;
    
    @Autowired
    private CourseDAO courseDAO ;
    
    public void saveOrUpdate(CourseBO entity) {
        courseDAO.save(entity);
    }
    
    public CourseBO findById(Long id) {
        return courseDAO.findById(id).orElse(null);
    }
    
    @Modifying
    public void delete(Long categoryId) {
        courseDAO.deleteById(categoryId);
    }
    
    public List<CourseBO> findAll(){
        return courseDAO.findAll();
    }
    
    public  DataTableResults<CourseBean> searchData(CourseForm form, HttpServletRequest req) {
        return courseDAO.searchData(uttData, form, req);
    }
    
    public  List<CourseBean> getByEducationLevel(Long educationLevelId) {
        return courseDAO.getByEducationLevel(uttData, educationLevelId);
    }
    
}
