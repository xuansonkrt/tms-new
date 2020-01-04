package application.tai.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import application.common.UttData;
import application.domain.DataTableResults;
import application.tai.bean.StaffCourseBean;
import application.tai.bo.StaffCourseBO;
import application.tai.dao.StaffCourseDAO;
import application.tai.form.StaffCourseForm;

@Service
public class StaffCourseService {
    @Autowired
    private UttData uttData;
    
    @Autowired
    private StaffCourseDAO staffCourseDAO ;
    
    public void saveOrUpdate(StaffCourseBO entity) {
        staffCourseDAO.save(entity);
    }
    
    public StaffCourseBO findById(Long id) {
        return staffCourseDAO.findById(id).orElse(null);
    }
    
    @Modifying
    public void delete(Long categoryId) {
        staffCourseDAO.deleteById(categoryId);
    }
    
    public List<StaffCourseBO> findAll(){
        return staffCourseDAO.findAll();
    }
    
    public DataTableResults<StaffCourseBean> searchData(StaffCourseForm form, HttpServletRequest req) {
        return staffCourseDAO.searchData(uttData, form, req);
    }
    
}
