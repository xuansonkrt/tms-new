package application.learningType.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "learning_type")
public class LearningTypeBO {
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
    
    @Column(name = "is_detail")
    private Long isDetail;
    
    @Column(name = "factor")
    private Double factor;
    
    @Column(name = "unit_name")
    private String unitName;
    
    @Column(name = "unit")
    private Double unit;
    
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

    
    public Long getIsDetail() {
        return isDetail;
    }

    
    public void setIsDetail(Long isDetail) {
        this.isDetail = isDetail;
    }

    
    public Double getFactor() {
        return factor;
    }

    
    public void setFactor(Double factor) {
        this.factor = factor;
    }

    
    public String getUnitName() {
        return unitName;
    }

    
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    
    public Double getUnit() {
        return unit;
    }

    
    public void setUnit(Double unit) {
        this.unit = unit;
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
