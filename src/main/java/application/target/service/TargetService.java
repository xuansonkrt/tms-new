package application.target.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import application.common.CommonUtil;
import application.common.UttData;
import application.target.bean.TargetBean;
import application.target.bo.TargetBO;
import application.target.dao.TargetDAO;

@Service
public class TargetService {
    
    @Autowired
    private UttData uttData;
    
    @Autowired
    private TargetDAO targetDAO ;
    
    public void saveOrUpdate(TargetBO entity) {
        targetDAO.save(entity);
    }
    
    public TargetBO findById(Long id) {
        return targetDAO.findById(id).orElse(null);
    }
    
    @Modifying
    public void delete(Long categoryId) {
        targetDAO.deleteById(categoryId);
    }
    
    public List<TargetBO> findAll(){
        return targetDAO.findAll();
    }
    
    public  List<TargetBean> getAll() {
        return targetDAO.getAll(uttData);
    }
    
    public boolean isDuplicate(Long theType, Long staffProperty) {
        List<TargetBO> list = targetDAO.findByTheTypeAndStaffPropertyId(theType, staffProperty);
        if(!CommonUtil.isNullOrEmpty(list)) {
            return true;
        }
        return false;
    }
}
