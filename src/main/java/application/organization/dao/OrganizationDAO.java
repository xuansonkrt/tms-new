package application.organization.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.common.CommonUtil;
import application.common.UttData;
import application.domain.DataTableResults;
import application.organization.bean.OrganizationBean;
import application.organization.bean.TreeBean;
import application.organization.bo.OrganizationBO;
import application.organization.form.OrganizationForm;

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
    
    public default DataTableResults<OrganizationBean> searchData(UttData uttData, OrganizationForm form, HttpServletRequest req) {
        List<Object> paramList = new ArrayList<>();
        String nativeSQL = "SELECT "
                + "     s.id AS id " 
                + "     , s.name as name " 
                + "     , s.code as code "
                + "     , s.note as note "
                + "     , o.name as parentName "
                + "     , s.phone_number as phoneNumber "
                + "     , s.email as email "
                + "     , s.address as address "
                + "     , s.the_order as theOrder "
                + "     , s.founded_date as foundedDate "
                + "     , DATE_FORMAT(s.founded_date,'%d/%m/%Y')  as foundedDateShow "
                + " FROM organization s "
                + "  LEFT JOIN organization o on s.parent_id = o.id ";

        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        
        CommonUtil.filter(form.getCode(), strCondition, paramList, "s.code");
        CommonUtil.filter(form.getName(), strCondition, paramList, "s.name");
        if(CommonUtil.NVL(form.getParentId())>0L) {
            CommonUtil.filter(String.format("/%s/", form.getParentId()), strCondition, paramList, "s.path");
        }
        

        String orderBy = " ORDER BY s.id DESC ";
        return uttData.findPaginationQuery(nativeSQL + strCondition.toString(), orderBy, paramList, OrganizationBean.class, Integer.MAX_VALUE);
    }
}
