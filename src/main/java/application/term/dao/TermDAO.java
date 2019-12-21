package application.term.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.common.CommonUtil;
import application.common.UttData;
import application.domain.DataTableResults;
import application.term.bean.TermBean;
import application.term.bo.TermBO;
import application.term.form.TermForm;

@Transactional
@Repository
public interface TermDAO extends JpaRepository<TermBO, Long>{
    public default DataTableResults<TermBean> searchData(UttData uttData, TermForm form, HttpServletRequest req) {
        List<Object> paramList = new ArrayList<>();
        String nativeSQL = "SELECT "
                + "     c.id AS id " 
                + "     , c.name as name " 
                + "     , c.code as code "
                + "     , c.year as year "
                + "     , c.the_order as theOrder "
                + "     , concat(c.year,'-',c.year+1) as schoolYear "
                + "     , c.begin_date as beginDate "
                + "     , c.end_date as endDate "
                + "     , DATE_FORMAT(c.begin_date,'%d/%m/%Y')  as beginDateShow "
                + "     , DATE_FORMAT(c.end_date,'%d/%m/%Y') as endDateShow "
                + " FROM term c ";

        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        
        CommonUtil.filter(form.getCode(), strCondition, paramList, "c.code");
        CommonUtil.filter(form.getName(), strCondition, paramList, "c.name");
        CommonUtil.filter(form.getYear(), strCondition, paramList, "c.year");

        String orderBy = " ORDER BY c.the_order ASC ";
        return uttData.findPaginationQuery(nativeSQL + strCondition.toString(), orderBy, paramList, TermBean.class, Integer.MAX_VALUE);
    }
}
