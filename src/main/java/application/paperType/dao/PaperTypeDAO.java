package application.paperType.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.common.CommonUtil;
import application.common.UttData;
import application.domain.DataTableResults;
import application.paperType.bean.PaperTypeBean;
import application.paperType.bo.PaperTypeBO;
import application.paperType.form.PaperTypeForm;

@Transactional
@Repository
public interface PaperTypeDAO extends JpaRepository<PaperTypeBO , Long>{
    public default DataTableResults<PaperTypeBean> searchData(UttData uttData, PaperTypeForm form, HttpServletRequest req) {
        List<Object> paramList = new ArrayList<>();
        String nativeSQL = "SELECT "
                + "     s.id AS id " 
                + "     , s.name as name " 
                + "     , s.code as code "
                + "     , s.note as note "
                + "     , s.research_point as researchPoint "
                + "     , s.unit as unit "
                + "     , s.unit_name as unitName "
                + " FROM paper_type s ";

        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        
        CommonUtil.filter(form.getCode(), strCondition, paramList, "s.code");
        CommonUtil.filter(form.getName(), strCondition, paramList, "s.name");

        String orderBy = " ORDER BY s.name ASC ";
        return uttData.findPaginationQuery(nativeSQL + strCondition.toString(), orderBy, paramList, PaperTypeBean.class, Integer.MAX_VALUE);
    }
}
