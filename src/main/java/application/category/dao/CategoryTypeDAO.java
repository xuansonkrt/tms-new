package application.category.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import application.category.bo.CategoryTypeBO;

@Transactional
@Repository
public interface CategoryTypeDAO extends JpaRepository<CategoryTypeBO, Long> {
    
    public List<CategoryTypeBO> findByNameIgnoreCaseContaining( String name);
    
    public List<CategoryTypeBO> findByCodeIgnoreCase( String code);
    
    @Query("SELECT c FROM CategoryTypeBO c WHERE LOWER(c.code)=LOWER(:code) AND c.id<>:id")
    public List<CategoryTypeBO> checkCode(@Param("id")Long id,@Param("code") String code);
    
    
}
