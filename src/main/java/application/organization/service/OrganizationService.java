package application.organization.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import application.common.UttData;
import application.organization.bean.TreeBean;
import application.organization.bo.OrganizationBO;
import application.organization.dao.OrganizationDAO;

@Service
public class OrganizationService {
    @Autowired
    private UttData uttData;
    
    @Autowired
    private OrganizationDAO organizationDAO ;
    
    public void saveOrUpdate(OrganizationBO entity) {
        organizationDAO.save(entity);
    }
    
    public OrganizationBO findById(Long id) {
        return organizationDAO.findById(id).orElse(null);
    }
    
    @Modifying
    public void delete(Long categoryId) {
        organizationDAO.deleteById(categoryId);
    }
    
    public List<OrganizationBO> findAll(){
        return organizationDAO.findAll();
    }
    
    public  List<TreeBean> getRootTree() {
        return organizationDAO.getRootTree(uttData);
    }
    
    public List<TreeBean> getChilrenNode(Long id) {
        return organizationDAO.getChilrenNode(uttData,id);
    }
}
