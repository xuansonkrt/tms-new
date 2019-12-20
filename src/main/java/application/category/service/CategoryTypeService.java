package application.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import application.category.bo.CategoryTypeBO;
import application.category.dao.CategoryTypeDAO;
import application.common.CommonUtil;

@Service
public class CategoryTypeService {
    @Autowired
    private CategoryTypeDAO categoryTypeDAO;
    
    public List<CategoryTypeBO> findAll(){
        return categoryTypeDAO.findAll();
    }
    
    public CategoryTypeBO findById(Long id) {
        return categoryTypeDAO.findById(id).orElse(null);
    }
    
    public void saveOrUpdate(CategoryTypeBO entity) {
        categoryTypeDAO.save(entity);
    }
    
    public List<CategoryTypeBO> findByNameIgnoreCaseContaining(String name){
        return categoryTypeDAO.findByNameIgnoreCaseContaining(name);
    }
    
    public List<CategoryTypeBO> findByCodeIgnoreCase(String code){
        return categoryTypeDAO.findByCodeIgnoreCase(code);
    }
    
    @Modifying
    public void delete(Long categoryId) {
        categoryTypeDAO.deleteById(categoryId);
    }
    
    public boolean checkCode(Long id, String code){
        List<CategoryTypeBO> lst = categoryTypeDAO.checkCode(id, code);
        if(CommonUtil.isNullOrEmpty(lst)) {
            return false;
        } else {
            return true;
        }
    }
}
