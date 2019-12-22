package application.learningType.form;

import java.util.Date;

public class LearningTypeForm {
    private Long id;
    private String code;
    private String name;
    private String note;
    private Long educationLevelId;
    private Long isDetail;
    private Double factor;
    private String unitName;
    private Double unit;
    private Date createdDate;
    private Long createdBy;
    private Date modifiedDate;
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
