package application.tai.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff_course")
public class StaffCourseBO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "staff_id")
    private Long staffId;
    
    @Column(name = "course_id")
    private Long courseId;
    
    @Column(name = "learning_type_id")
    private Long learningTypeId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "edu_point")
    private Double eduPoint;

    @Column(name = "finish_date")
    private Date finishDate;

    @Column(name = "term")
    private Long term;
    
    @Column(name = "year")
    private Long year;
    
    @Column(name = "organization_id")
    private Long organizationId;
    
    @Column(name = "education_level_id")
    private Long educationLevelId;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "modified_by")
    private Long modifiedBy;
    
    
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
