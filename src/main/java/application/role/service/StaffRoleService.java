package application.role.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import application.common.UttData;
import application.role.bo.StaffRoleBO;
import application.role.dao.StaffRoleDAO;

@Service
public class StaffRoleService {
    @Autowired
    private UttData uttData;
    
    @Autowired
    private StaffRoleDAO staffRoleDAO;

    
    public void saveOrUpdate(StaffRoleBO entity) {
        staffRoleDAO.save(entity);
    }
    
    public StaffRoleBO findById(Long id) {
        return staffRoleDAO.findById(id).orElse(null);
    }
    
    @Modifying
    public void delete(Long categoryId) {
        staffRoleDAO.deleteById(categoryId);
    }
    
    public List<StaffRoleBO> findAll(){
        return staffRoleDAO.findAll();
    }
}
