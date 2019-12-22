package application.course.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.course.bo.CourseBO;


@Transactional
@Repository
public interface CourseDAO extends JpaRepository<CourseBO, Long>{
    
}
