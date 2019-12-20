package application.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.category.bo.CategoryTypeBO;
import application.category.dao.CatetoryTypeDAO;

@Service
public class CategoryTypeService {
    @Autowired
    private CatetoryTypeDAO categoryTypeDAO;
    
    public List<CategoryTypeBO> findAll(){
        return categoryTypeDAO.findAll();
    }
    
    public CategoryTypeBO findById(Long id) {
        return categoryTypeDAO.findById(id).orElse(null);
    }
    
    public void saveOrUpdate(CategoryTypeBO entity) {
        categoryTypeDAO.save(entity);
    }
}
