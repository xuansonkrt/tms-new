package application.category.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.category.bean.CategoryBean;
import application.category.bo.CategoryBO;
import application.category.dao.CategoryDAO;
import application.category.form.CategoryForm;
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
}
