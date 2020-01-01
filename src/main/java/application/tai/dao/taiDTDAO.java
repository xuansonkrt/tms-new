package application.tai.dao;

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
import application.tai.bo.taiDTBO;
import application.organization.form.OrganizationForm;

@Transactional
@Repository
public interface taiDTDAO extends JpaRepository<taiDTBO, Long> {
    
}
