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
import application.tai.bean.StaffCourseBean;
import application.tai.bo.StaffCourseBO;
import application.tai.form.StaffCourseForm;

@Repository
@Transactional
public interface StaffCourseDAO  extends JpaRepository<StaffCourseBO,Long>{
    public default DataTableResults<StaffCourseBean> searchData(UttData uttData, StaffCourseForm form, HttpServletRequest req) {
        List<Object> paramList = new ArrayList<>();
        String nativeSQL = "SELECT "
                + "     s.id AS id " 
                + "     , s.amount as amount " 
                + "     , s.edu_point as eduPoint "
                + "     , lt.name as learningTypeName"
                + "     , sj.name as subjectName      "
                + "     , s.finish_date as finishDate "
                + "     , DATE_FORMAT(s.finish_date,'%d/%m/%Y')  as finish_date "
                + " FROM staff_course s "
                + " JOIN learning_type lt on s.learning_type_id = lt.id "
                + " JOIN course c on c.id = s.course_id "
                + " JOIN subject sj on sj.id = c.subject_id ";

        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        
        CommonUtil.filter(form.getTerm1(), strCondition, paramList, "s.term");
        CommonUtil.filter(form.getYear1(), strCondition, paramList, "s.year");
        CommonUtil.filter(form.getStaffId(), strCondition, paramList, "s.staff_id");
        

        String orderBy = " ORDER BY s.id DESC ";
        return uttData.findPaginationQuery(nativeSQL + strCondition.toString(), orderBy, paramList, StaffCourseBean.class, Integer.MAX_VALUE);
    }
}
