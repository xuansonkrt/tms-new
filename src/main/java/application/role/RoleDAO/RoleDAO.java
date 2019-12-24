package application.role.RoleDAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import application.role.bo.RoleBO;

@Transactional
@Repository
public interface RoleDAO extends JpaRepository<RoleBO, Long>{

    
    @Query(value = "select r.* " +
            "from staff_role ur " +
            "inner join staff u on(u.id=ur.staff_id) " +
            "inner join role r on(r.id=ur.role_id) " +
            "where ur.staff_id=:id", nativeQuery = true)
    RoleBO getRoleByUser(@Param("id") Integer userId);
    
}
