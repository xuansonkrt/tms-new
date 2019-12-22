package application.subject.bean;

import java.util.Date;

public class SubjectBean {

    private Long id;
    private String code;
    private String name;
    private String note;
    private Long educationLevelId;
    private Long learningTypeId;
    private Long credit;
    private Long classPeriod;
    private Long organizationId;
    private Date createdDate;
    private Long createdBy;
    private Date modifiedDate;
    private Long modifiedBy;
    private String organizationName;
    private String educationLevelName;
    
    
    
    
    public String getOrganizationName() {
        return organizationName;
    }

    
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    
    public String getEducationLevelName() {
        return educationLevelName;
    }

    
    public void setEducationLevelName(String educationLevelName) {
        this.educationLevelName = educationLevelName;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getNote() {
        return note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
    public Long getEducationLevelId() {
        return educationLevelId;
    }
    
    public void setEducationLevelId(Long educationLevelId) {
        this.educationLevelId = educationLevelId;
    }
    
    public Long getLearningTypeId() {
        return learningTypeId;
    }
    
    public void setLearningTypeId(Long learningTypeId) {
        this.learningTypeId = learningTypeId;
    }
    
    public Long getCredit() {
        return credit;
    }
    
    public void setCredit(Long credit) {
        this.credit = credit;
    }
    
    public Long getClassPeriod() {
        return classPeriod;
    }
    
    public void setClassPeriod(Long classPeriod) {
        this.classPeriod = classPeriod;
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
    
    
}
