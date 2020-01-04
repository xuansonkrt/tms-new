package application.tai.form;

import java.util.Date;

import javax.persistence.Column;

public class taiDTForm {
	public String year;
	public Long level;
	public Long parentId;
	
	
	public Long getParentId() {
		return parentId;
	}
	
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Long getLevel() {
		return level;
	}
	public void setLevel(Long level) {
		this.level = level;
	}
	
	
}
