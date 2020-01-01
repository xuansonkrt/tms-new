package application.tai.form;

import java.util.Date;

import javax.persistence.Column;

public class taiDTForm {

	private Long id;

    private Long staffId;

    private Long courseId;
    
    private Long learningTypeId;

    private Long amount;

    private Long eduPoint;

    private Long organizationId;

    private Long term;

    private Long year;

    private Date createdDate;

    private Long createdBy;

    private Date modifiedDate;

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

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getLearningTypeId() {
		return learningTypeId;
	}

	public void setLearningTypeId(Long learningTypeId) {
		this.learningTypeId = learningTypeId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getEduPoint() {
		return eduPoint;
	}

	public void setEduPoint(Long eduPoint) {
		this.eduPoint = eduPoint;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getTerm() {
		return term;
	}

	public void setTerm(Long term) {
		this.term = term;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	private Long modifiedBy;

}
