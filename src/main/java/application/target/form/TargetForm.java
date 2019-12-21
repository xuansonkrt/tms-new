package application.target.form;

import java.util.Date;

public class TargetForm {

    private Long id;
    private Long eduDuty;
    private Long researchDuty;
    private Long theType;
    private Long staffPropertyId;
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
    
    public Long getEduDuty() {
        return eduDuty;
    }
    
    public void setEduDuty(Long eduDuty) {
        this.eduDuty = eduDuty;
    }
    
    public Long getResearchDuty() {
        return researchDuty;
    }
    
    public void setResearchDuty(Long researchDuty) {
        this.researchDuty = researchDuty;
    }
    
    public Long getTheType() {
        return theType;
    }
    
    public void setTheType(Long theType) {
        this.theType = theType;
    }
    
    public Long getStaffPropertyId() {
        return staffPropertyId;
    }
    
    public void setStaffPropertyId(Long staffPropertyId) {
        this.staffPropertyId = staffPropertyId;
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
