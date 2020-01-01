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
import application.tai.bo.taiNCBO;



@Transactional
@Repository
public interface taiNCDAO extends JpaRepository<taiNCBO, Long> {
    
}
