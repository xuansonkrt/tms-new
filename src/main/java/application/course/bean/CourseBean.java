package application.course.bean;

import java.util.Date;

public class CourseBean {

    private Long id;
    private String code;
    private String name;
    private Long termId;
    private Long subjectId;
    private Long studentAmount;
    private Date createdDate;
    private Long createdBy;
    private Date modifiedDate;
    private Long modifiedBy;
    private Long educationLevelId;
    private String subjectName;
    private String educationLevelName;
    private String termCode;
    private String schoolYear;
    

    
    public String getSubjectName() {
        return subjectName;
    }

    
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    
    public String getEducationLevelName() {
        return educationLevelName;
    }

    
    public void setEducationLevelName(String educationLevelName) {
        this.educationLevelName = educationLevelName;
    }

    
    public String getTermCode() {
        return termCode;
    }

    
    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }

    
    public String getSchoolYear() {
        return schoolYear;
    }

    
    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Long getEducationLevelId() {
        return educationLevelId;
    }

    public void setEducationLevelId(Long educationLevelId) {
        this.educationLevelId = educationLevelId;
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

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getStudentAmount() {
        return studentAmount;
    }

    public void setStudentAmount(Long studentAmount) {
        this.studentAmount = studentAmount;
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
