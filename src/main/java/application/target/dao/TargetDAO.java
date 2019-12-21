package application.target.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.common.UttData;
import application.target.bean.TargetBean;
import application.target.bo.TargetBO;


@Transactional
@Repository
public interface TargetDAO extends JpaRepository<TargetBO, Long>{
    
    public default List<TargetBean> getAll(UttData uttData) {
        String hql = "SELECT " 
                + "    t.id as id "
                + "    ,t.edu_duty as eduDuty "
                + "    ,t.research_duty as researchDuty "
                + "    ,c.name as levelTitleName "
                + " FROM target t "
                + " LEFT JOIN category c ON c.id=t.staff_property_id "
                + " WHERE 1 = 1  "
                + " ORDER BY c.the_order ASC ";
        SQLQuery query = uttData.createSQLQuery(hql);
        uttData.setResultTransformer(query, TargetBean.class);
        return query.list();
    }
    
    public List<TargetBO> findByTheTypeAndStaffPropertyId(Long theType, Long staffProperty);
}
