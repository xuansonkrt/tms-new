package application.course.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.common.CommonUtil;
import application.common.UttData;
import application.course.bean.CourseBean;
import application.course.bo.CourseBO;
import application.course.form.CourseForm;
import application.domain.DataTableResults;


@Transactional
@Repository
public interface CourseDAO extends JpaRepository<CourseBO, Long>{
    public default DataTableResults<CourseBean> searchData(UttData uttData, CourseForm form, HttpServletRequest req) {
        List<Object> paramList = new ArrayList<>();
        String nativeSQL = "SELECT "
                + "     s.id AS id " 
                + "     , s.name as name " 
                + "     , s.code as code "
                + "     , s.term_id as termId "
                + "     , s.student_amount as studentAmount "
                + "     , t.code as termCode "
                + "     , concat(t.year,'-',t.year+1) as schoolYear "
                + "     , c.name as educationLevelName "
                + "     , sub.name as subjectName "
                + " FROM course s "
                + " INNER JOIN category c ON c.id = s.education_level_id" //cap dao tao
                + " INNER JOIN subject sub ON sub.id = s.subject_id"
                + " INNER JOIN term t ON t.id = s.term_id";

        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        
        CommonUtil.filter(form.getCode(), strCondition, paramList, "s.code");
        CommonUtil.filter(form.getName(), strCondition, paramList, "s.name");
        CommonUtil.filter(form.getEducationLevelId(), strCondition, paramList, " s.education_level_id");
        CommonUtil.filter(form.getSubjectId(), strCondition, paramList, " s.subject_id");
        CommonUtil.filter(form.getTermId(), strCondition, paramList, " s.term_id");
        
        String orderBy = " ORDER BY c.name ASC ";
        return uttData.findPaginationQuery(nativeSQL + strCondition.toString(), orderBy, paramList, CourseBean.class, Integer.MAX_VALUE);
    }
}
