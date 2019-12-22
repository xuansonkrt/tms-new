package application.paperType.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import application.common.UttData;
import application.paperType.bo.PaperTypeBO;
import application.paperType.dao.PaperTypeDAO;

@Service
public class PaperTypeService {
    @Autowired
    private UttData uttData;
    
    @Autowired
    private PaperTypeDAO paperTypeDAO;
    
    public void saveOrUpdate(PaperTypeBO entity) {
        paperTypeDAO.save(entity);
    }
    
    public PaperTypeBO findById(Long id) {
        return paperTypeDAO.findById(id).orElse(null);
    }
    
    @Modifying
    public void delete(Long categoryId) {
        paperTypeDAO.deleteById(categoryId);
    }
    
    public List<PaperTypeBO> findAll(){
        return paperTypeDAO.findAll();
    }
}
