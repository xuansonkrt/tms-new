package application.category.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import application.category.bean.CategoryBean;
import application.category.bo.CategoryBO;
import application.category.bo.CategoryTypeBO;
import application.category.dao.CategoryDAO;
import application.category.form.CategoryForm;
import application.common.CommonUtil;
import application.common.UttData;
import application.domain.DataTableResults;

@Service
public class CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;
    
    
    @Autowired
    private UttData uttData;
    
    public List<CategoryBO> findByCategoryTypeId(Long categoryId){
        return categoryDAO.findByCategoryTypeId(categoryId);
    }
    
    public DataTableResults<CategoryBean> getCategory( CategoryForm form, HttpServletRequest req) {
        return categoryDAO.getCategory(uttData, form, req);
    }
    
    
    
    public boolean checkCode(Long id, String code){
        List<CategoryBO> lst = categoryDAO.checkCode(id, code);
        if(CommonUtil.isNullOrEmpty(lst)) {
            return false;
        } else {
            return true;
        }
    }
    
    public void saveOrUpdate(CategoryBO entity) {
        categoryDAO.save(entity);
    }
    
    public CategoryBO findById(Long id) {
        return categoryDAO.findById(id).orElse(null);
    }
    
    @Modifying
    public void delete(Long categoryId) {
        categoryDAO.deleteById(categoryId);
    }
    
    public List<CategoryBean> getByCategoryTypeCode( String categoryTypeCode) {
        return categoryDAO.getByCategoryTypeCode(uttData, categoryTypeCode);
    }
}
