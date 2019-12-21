package application.category.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import application.category.bean.CategoryBean;
import application.category.bo.CategoryBO;
import application.category.form.CategoryForm;
import application.common.CommonUtil;
import application.common.UttData;
import application.domain.DataTableResults;
import application.user.bean.UserBean;

@Transactional
@Repository
public interface CategoryDAO extends JpaRepository<CategoryBO, Long> {

    @Query("SELECT c FROM CategoryBO c WHERE LOWER(c.code)=LOWER(:code) AND c.id<>:id")
    public List<CategoryBO> checkCode(@Param("id")Long id,@Param("code") String code);
    
    
    public List<CategoryBO> findByCategoryTypeId(Long categoryTypeId);
    
    
    public default DataTableResults<CategoryBean> getCategory(UttData uttData, CategoryForm form, HttpServletRequest req) {
        List<Object> paramList = new ArrayList<>();
        String nativeSQL = "SELECT "
                + "     c.id AS id " 
                + "     , c.name as name " 
                + "     , c.code as code "
                + "     , c.category_type_id as categoryTypeId "
                + "     , c.effect_date as effectDate "
                + "     , c.expired_date as expiredDate "
                + "     , DATE_FORMAT(c.effect_date,'%d/%m/%Y')  as effectDateShow "
                + "     , DATE_FORMAT(c.expired_date,'%d/%m/%Y') as expiredDateShow "
                
                + "     , c.the_order as theOrder "
                + " FROM category c ";

        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        
        CommonUtil.filter(form.getCode(), strCondition, paramList, "c.code");
        CommonUtil.filter(form.getName(), strCondition, paramList, "c.name");
        CommonUtil.filter(form.getCategoryTypeId(), strCondition, paramList, "c.category_type_id");

        String orderBy = " ORDER BY c.the_order ASC ";
        return uttData.findPaginationQuery(nativeSQL + strCondition.toString(), orderBy, paramList, CategoryBean.class, Integer.MAX_VALUE);
    }
    
    public default List<CategoryBean> getByCategoryTypeCode(UttData uttData, String categoryTypeCode) {
        String hql = "SELECT " 
                + "    c.id as id "
                + "    ,c.name as name "
                + " FROM category c "
                + " INNER JOIN category_type ct ON ct.id=c.category_type_id "
                + " WHERE 1 = 1 AND LOWER(ct.code) = :categoryTypeCode "
                + " ORDER BY c.name ASC ";
        SQLQuery query = uttData.createSQLQuery(hql);
        query.setParameter("categoryTypeCode", categoryTypeCode.toLowerCase());
        uttData.setResultTransformer(query, CategoryBean.class);
        return query.list();
    }
}
