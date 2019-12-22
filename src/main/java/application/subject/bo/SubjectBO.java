package application.subject.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class SubjectBO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;
    
    @Column(name = "code")
    private String code;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "note")
    private String note;
    
    @Column(name = "education_level_id")
    private Long educationLevelId;
    
//    @Column(name = "learning_type_id")
//    private Long learningTypeId;
    
    @Column(name = "credit")
    private Long credit;
    
    @Column(name = "class_period")
    private Long classPeriod;
    
    @Column(name = "organization_id")
    private Long organizationId;
    
    @Column(name = "created_date")
    private Date createdDate;
    
    @Column(name = "created_by")
    private Long createdBy;
    
    @Column(name = "modified_date")
    private Date modifiedDate;
    
    @Column(name = "modified_by")
    private Long modifiedBy;

    
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

    
//    public Long getLearningTypeId() {
//        return learningTypeId;
//    }
//
//    
//    public void setLearningTypeId(Long learningTypeId) {
//        this.learningTypeId = learningTypeId;
//    }

    
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
