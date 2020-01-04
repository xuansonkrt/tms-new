package application.role.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.role.bo.StaffRoleBO;

@Repository
@Transactional
public interface StaffRoleDAO extends JpaRepository<StaffRoleBO, Long>{

}
