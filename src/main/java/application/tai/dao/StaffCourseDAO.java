package application.tai.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.tai.bo.StaffCourseBO;

@Repository
@Transactional
public interface StaffCourseDAO  extends JpaRepository<StaffCourseBO,Long>{

}
