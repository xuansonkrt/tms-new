package application.role.bo;

import javax.persistence.*;

import application.staff.bo.StaffBO;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "roles")
public class RoleBO {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @javax.persistence.Id
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "staff_role",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "staff_id")})
    private Set<StaffBO> listRole = new HashSet<>();


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<StaffBO> getListRole() {
        return listRole;
    }

    public void setListRole(Set<StaffBO> listRole) {
        this.listRole = listRole;
    }
}
