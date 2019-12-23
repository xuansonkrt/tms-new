package application.term.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import application.common.UttData;
import application.domain.DataTableResults;
import application.term.bean.TermBean;
import application.term.bo.TermBO;
import application.term.dao.TermDAO;
import application.term.form.TermForm;

@Service
public class TermService {
    @Autowired
    private UttData uttData;
    
    @Autowired
    private TermDAO termDAO;
    
    public void saveOrUpdate(TermBO entity) {
        termDAO.save(entity);
    }
    
    public TermBO findById(Long id) {
        return termDAO.findById(id).orElse(null);
    }
    
    @Modifying
    public void delete(Long categoryId) {
        termDAO.deleteById(categoryId);
    }
    
    public List<TermBO> findAll(){
        return termDAO.findAll();
    }
    
    public DataTableResults<TermBean> searchData(TermForm form, HttpServletRequest req) {
        return termDAO.searchData(uttData, form, req);
    }
    
    public List<TermBean> getAllCombobox( ) {
        return termDAO.getAllCombobox(uttData);
    }
}
