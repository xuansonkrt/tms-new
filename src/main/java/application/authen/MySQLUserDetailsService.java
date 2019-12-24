package application.authen;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import application.role.bo.RoleBO;
import application.staff.bo.StaffBO;
import application.staff.service.StaffService;

@Service("userDetailsService")
public class MySQLUserDetailsService implements UserDetailsService {

    @Autowired
    private StaffService staffService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        StaffBO user = staffService.findUserByUsername(s);
        if(user != null) {

            List<RoleBO> listActiveRoles = staffService.getActiveListRole(user.getId());
            boolean isActive = true;

            if(listActiveRoles.size() == 0) {
                isActive = false;
            }

            // roles set
            Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
            for (RoleBO role : listActiveRoles) {
                setAuths.add(new SimpleGrantedAuthority(role.getName()));
            }

            // make user for spring-security
            org.springframework.security.core.userdetails.User userDetail =
                    new org.springframework.security.core.userdetails.User(s, user.getPasswordHash(),
                            isActive, true, true, true, setAuths);

            return userDetail;
        }
        throw new UsernameNotFoundException(s + " not found");
    }
}
