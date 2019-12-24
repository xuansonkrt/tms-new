package application.staff.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import application.common.UttData;
import application.domain.DataTableResults;
import application.staff.bean.StaffBean;
import application.staff.bo.StaffBO;
import application.staff.dao.StaffDAO;
import application.staff.form.StaffForm;

@Service
public class StaffService {
    @Autowired
    private UttData uttData;
    
    @Autowired
    private StaffDAO staffDAO;
    
    public void saveOrUpdate(StaffBO entity) {
        staffDAO.save(entity);
    }
    
    public StaffBO findById(Long id) {
        return staffDAO.findById(id).orElse(null);
    }
    
    @Modifying
    public void delete(Long categoryId) {
        staffDAO.deleteById(categoryId);
    }
    
    public List<StaffBO> findAll(){
        return staffDAO.findAll();
    }
    
    
    public DataTableResults<StaffBean> searchData(StaffForm form, HttpServletRequest req) {
        return staffDAO.searchData(uttData, form, req);
    }
}
