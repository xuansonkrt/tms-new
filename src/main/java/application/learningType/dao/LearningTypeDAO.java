package application.learningType.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.common.CommonUtil;
import application.common.UttData;
import application.course.bean.CourseBean;
import application.domain.DataTableResults;
import application.learningType.bean.LearningTypeBean;
import application.learningType.bo.LearningTypeBO;
import application.learningType.form.LearningTypeForm;

@Transactional
@Repository
public interface LearningTypeDAO extends JpaRepository<LearningTypeBO , Long>{
    
    
    public default DataTableResults<LearningTypeBean> searchData(UttData uttData, LearningTypeForm form, HttpServletRequest req) {
        List<Object> paramList = new ArrayList<>();
        String nativeSQL = "SELECT "
                + "     s.id AS id " 
                + "     , s.name as name " 
                + "     , s.code as code "
                + "     , s.note as note "
                + "     , s.factor as factor "
                + "     , s.unit as unit "
                + "     , s.unit_name as unitName "
                + "     , c.name as educationLevelName "
                + " FROM learning_type s "
                + " INNER JOIN category c ON c.id = s.education_level_id";

        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        
        CommonUtil.filter(form.getCode(), strCondition, paramList, "s.code");
        CommonUtil.filter(form.getName(), strCondition, paramList, "s.name");
        CommonUtil.filter(form.getEducationLevelId(), strCondition, paramList, " s.education_level_id");

        String orderBy = " ORDER BY c.name ASC ";
        return uttData.findPaginationQuery(nativeSQL + strCondition.toString(), orderBy, paramList, LearningTypeBean.class, Integer.MAX_VALUE);
    }
    
    public default List<LearningTypeBean> getByEducationLevel(UttData uttData, Long educationLevelId) {
        String hql = " SELECT s.id as id,"
                + " s.name as name, "
                + " s.factor as factor,"
                + " s.unit as unit, "
                + " s.unit_name as unitName, "
                + " s.note as note "
                + " FROM learning_type s "
                + "WHERE :educationLevelId is null OR s.education_level_id = :educationLevelId";
        SQLQuery query = uttData.createSQLQuery(hql);
        query.setParameter("educationLevelId", educationLevelId);
        
        uttData.setResultTransformer(query, LearningTypeBean.class);
        return query.list();
    }
}
