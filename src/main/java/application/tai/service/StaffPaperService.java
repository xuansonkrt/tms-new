package application.tai.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import application.common.UttData;
import application.domain.DataTableResults;
import application.tai.bean.StaffPaperBean;
import application.tai.bo.StaffPaperBO;
import application.tai.dao.StaffPaperDAO;
import application.tai.form.StaffPaperForm;

@Service
public class StaffPaperService {
    @Autowired
    private UttData uttData;
    
    @Autowired
    private StaffPaperDAO staffPaperDAO ;
    
    public void saveOrUpdate(StaffPaperBO entity) {
        staffPaperDAO.save(entity);
    }
    
    public StaffPaperBO findById(Long id) {
        return staffPaperDAO.findById(id).orElse(null);
    }
    
    @Modifying
    public void delete(Long categoryId) {
        staffPaperDAO.deleteById(categoryId);
    }
    
    public List<StaffPaperBO> findAll(){
        return staffPaperDAO.findAll();
    }
    
    public DataTableResults<StaffPaperBean> searchData(StaffPaperForm form, HttpServletRequest req) {
        return staffPaperDAO.searchData(uttData, form, req);
    }
}
