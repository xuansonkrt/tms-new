package application.tai.form;

import java.util.Date;

public class StaffCourseForm {
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
    
    private Long term1;
    private Long year1;
    private Long organizationId;
    private Date createdDate;
    private Date modifiedDate;
    private Long createdBy;
    private Long modifiedBy;
    private String subjectName;
    private Long amountStudent;
    private Long educationLevelId;
    
    
    
    
    
    
    public Long getEducationLevelId() {
        return educationLevelId;
    }


    
    public void setEducationLevelId(Long educationLevelId) {
        this.educationLevelId = educationLevelId;
    }


    public String getSubjectName() {
        return subjectName;
    }

    
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    
    public Long getAmountStudent() {
        return amountStudent;
    }

    
    public void setAmountStudent(Long amountStudent) {
        this.amountStudent = amountStudent;
    }

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
    
    public Long getTerm1() {
        return term1;
    }
    
    public void setTerm1(Long term1) {
        this.term1 = term1;
    }
    
    public Long getYear1() {
        return year1;
    }
    
    public void setYear1(Long year1) {
        this.year1 = year1;
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
