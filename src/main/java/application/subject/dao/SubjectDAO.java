package application.subject.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.common.CommonUtil;
import application.common.UttData;
import application.domain.DataTableResults;
import application.subject.bean.SubjectBean;
import application.subject.bo.SubjectBO;
import application.subject.form.SubjectForm;


@Transactional
@Repository
public interface SubjectDAO extends JpaRepository<SubjectBO, Long>{
    public default DataTableResults<SubjectBean> searchData(UttData uttData, SubjectForm form, HttpServletRequest req) {
        List<Object> paramList = new ArrayList<>();
        String nativeSQL = "SELECT "
                + "     s.id AS id " 
                + "     , s.name as name " 
                + "     , s.code as code "
                + "     , s.note as note "
                + "     , s.credit as credit "
                + "     , s.class_period as classPeriod "
                + "     , c.name as educationLevelName "
                + "     , o.name as organizationName "

                + " FROM subject s "
                + " LEFT JOIN category c ON c.id = s.education_level_id"
                + " LEFT JOIN organization o ON c.id = s.organization_id";

        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        
        CommonUtil.filter(form.getCode(), strCondition, paramList, "s.code");
        CommonUtil.filter(form.getName(), strCondition, paramList, "s.name");
        CommonUtil.filter(form.getEducationLevelId(), strCondition, paramList, " s.education_level_id");

        String orderBy = " ORDER BY o.name ASC ";
        return uttData.findPaginationQuery(nativeSQL + strCondition.toString(), orderBy, paramList, SubjectBean.class, Integer.MAX_VALUE);
    }
}