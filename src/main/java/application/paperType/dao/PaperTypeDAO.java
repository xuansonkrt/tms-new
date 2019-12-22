package application.paperType.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.paperType.bo.PaperTypeBO;

@Transactional
@Repository
public interface PaperTypeDAO extends JpaRepository<PaperTypeBO , Long>{
    
}
