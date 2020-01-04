package application.tai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import application.common.UttData;
import application.tai.bo.StaffCourseBO;
import application.tai.bo.StaffPaperBO;
import application.tai.dao.StaffCourseDAO;

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
    
}
