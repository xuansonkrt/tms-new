package application.staff.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import application.common.CommonUtil;
import application.common.UttData;
import application.domain.DataTableResults;
import application.role.RoleDAO.RoleDAO;
import application.role.bo.RoleBO;
import application.role.bo.StaffRoleBO;
import application.staff.bean.StaffBean;
import application.staff.bo.StaffBO;
import application.staff.dao.StaffDAO;
import application.staff.form.StaffForm;
import application.tai.bean.taiTKBean;

@Service
public class StaffService {
    @Autowired
    private UttData uttData;
    
    @Autowired
    private StaffDAO staffDAO;
    
    @Autowired
    private RoleDAO roleDAO;
    
    public void saveOrUpdate(StaffBO entity) {
        staffDAO.save(entity);
    }
    
    public StaffBO findById(Long id) {
        return staffDAO.findById(id).orElse(null);
    }
    
    @Modifying
    public void delete(Long categoryId) {
        staffDAO.deleteById(categoryId);
    }
    
    public List<StaffBO> findAll(){
        return staffDAO.findAll();
    }
    
    
    public DataTableResults<StaffBean> searchData(StaffForm form, HttpServletRequest req) {
        return staffDAO.searchData(uttData, form, req);
    }
    
    public List<RoleBO> getActiveListRole(Long staffId) {
        List<StaffRoleBO> listUserRoles = StreamSupport
                .stream(staffDAO.findRolesOfUser(staffId).spliterator(), false).collect(Collectors.toList());

        return getListRole().stream().filter(role -> {
            return (listUserRoles.stream().filter(userRole -> userRole.getRoleId() == role.getId()).findFirst().orElse(null) != null);
        }).collect(Collectors.toList());
    }
    
    public List<RoleBO> getListRole() {
        return StreamSupport
                .stream(roleDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());

    }
    
    public StaffBO findUserByUsername(String username) {
        return StreamSupport
                .stream(staffDAO.findByUsername(username).spliterator(), false)
                .findFirst().orElse(null);
    }
    
    public List<StaffBean> getStaffOrg(Long id) {
        return staffDAO.getStaffOrg(uttData, id);
    }
    
    public StaffBean staffInfo(Long id) {
        List<StaffBean> lst =staffDAO.getStaff(uttData, id);
        if(CommonUtil.isNullOrEmpty(lst)) {
            return null;
        } else {
            return lst.get(0);
        }
    }
    
    public List<taiTKBean> getStaffCarriagebyListOrg(Long id) {
        return staffDAO.getStaffCarriagebyListOrg(uttData, id);
    }
    
}
