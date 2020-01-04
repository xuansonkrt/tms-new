package application.tai.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * UserBean
 *
 * @author
 * @since 1.0
 * @version 1.0
 */
public class taiTKBean {
	public String name;
	public String code;
	public Long id;
	public Long gio_nc;
	public Long NC_effecientcy;
	public Long gio_gd;
	public Long GD_effecientcy;
	public Long tai_gd;
	public Long tai_nc;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getGio_nc() {
		return gio_nc;
	}
	public void setGio_nc(Long gio_nc) {
		this.gio_nc = gio_nc;
	}
	public Long getNC_effecientcy() {
		return NC_effecientcy;
	}
	public void setNC_effecientcy(Long nC_effecientcy) {
		NC_effecientcy = nC_effecientcy;
	}
	public Long getGio_gd() {
		return gio_gd;
	}
	public void setGio_gd(Long gio_gd) {
		this.gio_gd = gio_gd;
	}
	public Long getGD_effecientcy() {
		return GD_effecientcy;
	}
	public void setGD_effecientcy(Long gD_effecientcy) {
		GD_effecientcy = gD_effecientcy;
	}
	public Long getTai_gd() {
		return tai_gd;
	}
	public void setTai_gd(Long tai_gd) {
		this.tai_gd = tai_gd;
	}
	public Long getTai_nc() {
		return tai_nc;
	}
	public void setTai_nc(Long tai_nc) {
		this.tai_nc = tai_nc;
	}
    
}