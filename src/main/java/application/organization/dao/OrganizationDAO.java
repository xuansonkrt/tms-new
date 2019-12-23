package application.organization.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.common.UttData;
import application.organization.bean.TreeBean;
import application.organization.bo.OrganizationBO;

@Transactional
@Repository
public interface OrganizationDAO extends JpaRepository<OrganizationBO, Long> {
    public default List<TreeBean> getRootTree(UttData uttData) {
        String hql = "SELECT " 
                + "    s.id as id "
                + "    ,s.name as text "
                + "    ,s.parent_id as parent "
                + " FROM organization s "
                + " WHERE 1 = 1 AND s.level = 1  "
                + " ORDER BY s.name ASC ";
        SQLQuery query = uttData.createSQLQuery(hql);
        uttData.setResultTransformer(query, TreeBean.class);
        return query.list();
    }
    
    public default List<TreeBean> getChilrenNode(UttData uttData, Long id) {
        String hql = "SELECT " 
                + "    s.id as id "
                + "    ,s.name as text "
                + "    ,s.parent_id as parent "
                + " FROM organization s "
                + " WHERE 1 = 1  AND s.parent_id=:id "
                + " ORDER BY s.name ASC ";
        SQLQuery query = uttData.createSQLQuery(hql);
        query.setParameter("id", id);
        uttData.setResultTransformer(query, TreeBean.class);
        return query.list();
    }
}
