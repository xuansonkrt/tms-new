package application.category.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import application.category.bean.CategoryBean;
import application.category.bean.CategoryTypeBean;
import application.category.bo.CategoryTypeBO;
import application.common.UttData;

@Transactional
@Repository
public interface CategoryTypeDAO extends JpaRepository<CategoryTypeBO, Long> {
    
    public List<CategoryTypeBO> findByNameIgnoreCaseContainingOrderByIdDesc( String name);
    
    public List<CategoryTypeBO> findByCodeIgnoreCase( String code);
    
    @Query("SELECT c FROM CategoryTypeBO c WHERE LOWER(c.code)=LOWER(:code) AND c.id<>:id")
    public List<CategoryTypeBO> checkCode(@Param("id")Long id,@Param("code") String code);
    
    public default List<CategoryTypeBean> getAllSearch(UttData uttData, String name) {
        String hql = "SELECT " 
                + "    c.id as id "
                + "    ,c.name as name "
                + " FROM category_type c "
                + " WHERE 1 = 1 AND  LOWER(c.name) LIKE concat('%',:name,'%')  "
                + " ORDER BY c.id DESC ";
        SQLQuery query = uttData.createSQLQuery(hql);
        query.setParameter("name", name.toLowerCase());
        uttData.setResultTransformer(query, CategoryBean.class);
        return query.list();
    }
}
