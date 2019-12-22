package application.subject.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import application.common.UttData;
import application.domain.DataTableResults;
import application.subject.bean.SubjectBean;
import application.subject.bo.SubjectBO;
import application.subject.dao.SubjectDAO;
import application.subject.form.SubjectForm;

@Service
public class SubjectService {
    
    @Autowired
    private UttData uttData;
    
    @Autowired
    private SubjectDAO subjectDAO ;
    
    public void saveOrUpdate(SubjectBO entity) {
        subjectDAO.save(entity);
    }
    
    public SubjectBO findById(Long id) {
        return subjectDAO.findById(id).orElse(null);
    }
    
    @Modifying
    public void delete(Long categoryId) {
        subjectDAO.deleteById(categoryId);
    }
    
    public List<SubjectBO> findAll(){
        return subjectDAO.findAll();
    }
    
    public DataTableResults<SubjectBean> searchData(SubjectForm form, HttpServletRequest req) {
        return subjectDAO.searchData(uttData, form, req);
    }
}
