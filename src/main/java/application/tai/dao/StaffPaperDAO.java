package application.tai.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.common.CommonUtil;
import application.common.UttData;
import application.domain.DataTableResults;
import application.tai.bean.StaffPaperBean;
import application.tai.bo.StaffPaperBO;
import application.tai.form.StaffPaperForm;

@Repository
@Transactional
public interface StaffPaperDAO extends JpaRepository<StaffPaperBO, Long>{
    public default DataTableResults<StaffPaperBean> searchData(UttData uttData, StaffPaperForm form, HttpServletRequest req) {
        List<Object> paramList = new ArrayList<>();
        String nativeSQL = "SELECT "
                + "     s.id AS id " 
                + "     , s.name as name " 
                + "     , s.code as code "
                + "     , s.author as author "
                + "     , s.research_point as researchPoint "
                + "     , s.number_author as numberAuthor "
                + "     , s.publish_date as publishDate "
                + "     , DATE_FORMAT(s.publish_date,'%d/%m/%Y')  as publishDateShow "
                + " FROM staff_paper s ";

        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        
        CommonUtil.filter(form.getTerm(), strCondition, paramList, "s.term");
        CommonUtil.filter(form.getYear(), strCondition, paramList, "s.year");
        CommonUtil.filter(form.getStaffId(), strCondition, paramList, "s.staff_id");
        

        String orderBy = " ORDER BY s.id DESC ";
        return uttData.findPaginationQuery(nativeSQL + strCondition.toString(), orderBy, paramList, StaffPaperBean.class, Integer.MAX_VALUE);
    }
}
