package application.role.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "staff_role")
public class StaffRoleBO {
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "staff_id")
    private Long staffId;

    @Column(name = "role_id")
    private Long roleId;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Long getStaffId() {
        return staffId;
    }

    
    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    
    public Long getRoleId() {
        return roleId;
    }

    
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }


    public StaffRoleBO(Long id, Long staffId, Long roleId) {
        super();
        this.id = id;
        this.staffId = staffId;
        this.roleId = roleId;
    }


    public StaffRoleBO() {
        super();
    }
    
    

}
