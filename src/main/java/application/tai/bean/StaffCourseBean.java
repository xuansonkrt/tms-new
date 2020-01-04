package application.tai.bean;

import java.util.Date;

public class StaffCourseBean {
    private Long id;
    private Long staffId;
    private Long courseId;
    private Long learningTypeId;
    private Double amount;
    private Double eduPoint;
    private Date finishDate;
    private String finishDateShow;
    private Long term;
    private Long year;
    private Long organizationId;
    private Date createdDate;
    private Date modifiedDate;
    private Long createdBy;
    private Long modifiedBy;
    
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
    
    public Double getAmount() {
        return amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public Double getEduPoint() {
        return eduPoint;
    }
    
    public void setEduPoint(Double eduPoint) {
        this.eduPoint = eduPoint;
    }
    
    public Date getFinishDate() {
        return finishDate;
    }
    
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
    
    public String getFinishDateShow() {
        return finishDateShow;
    }
    
    public void setFinishDateShow(String finishDateShow) {
        this.finishDateShow = finishDateShow;
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
    
    public Long getOrganizationId() {
        return organizationId;
    }
    
    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
    
    public Date getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    public Date getModifiedDate() {
        return modifiedDate;
    }
    
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    
    public Long getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
    
    public Long getModifiedBy() {
        return modifiedBy;
    }
    
    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    
    
}
