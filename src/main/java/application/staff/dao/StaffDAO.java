package application.staff.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import application.common.CommonUtil;
import application.common.UttData;
import application.domain.DataTableResults;
import application.role.bo.StaffRoleBO;
import application.staff.bean.StaffBean;
import application.staff.bo.StaffBO;
import application.staff.form.StaffForm;

@Transactional
@Repository
public interface StaffDAO  extends JpaRepository<StaffBO, Long> {
    public default DataTableResults<StaffBean> searchData(UttData uttData, StaffForm form, HttpServletRequest req) {
        List<Object> paramList = new ArrayList<>();
        String nativeSQL = "SELECT "
                + "     s.id AS id " 
                + "     , s.name as name " 
                + "     , s.code as code "
                + "     , s.address as address "
                + "     , s.gender as gender "
                + "     , s.email as email "
                + "     , s.user_name as userName "
                + "     , s.phone_number as phoneNumber "
                + "     , DATE_FORMAT(s.date_of_birth,'%d/%m/%Y')  as dateOfBirthShow "
                + "     , o.name as organizationName "
                + "     , c1.name as academicLevelName "
                + "     , c2.name as academicTitleName "
                + "     , c3.name as armyRankName "
                + "     , c4.name as levelTitleName "
                + " FROM staff s "
                + " LEFT JOIN organization o ON o.id = s.organization_id"
                + " LEFT JOIN category c1 ON c1.id = s.academic_level_id"
                + " LEFT JOIN category c2 ON c2.id = s.academic_title_id"
                + " LEFT JOIN category c3 ON c3.id = s.army_rank_id"
                + " LEFT JOIN category c4 ON c4.id = s.level_title_id";

        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        
        CommonUtil.filter(form.getCode(), strCondition, paramList, "s.code");
        CommonUtil.filter(form.getName(), strCondition, paramList, "s.name");
        CommonUtil.filter(form.getOrganizationId(), strCondition, paramList, " s.organization_id");

        String orderBy = " ORDER BY s.id DESC ";
        return uttData.findPaginationQuery(nativeSQL + strCondition.toString(), orderBy, paramList, StaffBean.class, Integer.MAX_VALUE);
    }
    
    @Transactional(readOnly = true)
    @Query("select u from staff_role u where u.staffId = :id")
    Iterable<StaffRoleBO> findRolesOfUser(@Param("id") Long userId);
    
    @Transactional(readOnly = true)
    @Query("select u from staff u where u.userName = :username")
    Iterable<StaffBO> findByUsername(@Param("username") String userName);
}
