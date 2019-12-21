package application.target.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "target")
public class TargetBO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;
    
    @Column(name = "edu_duty")
    private Long eduDuty;
    
    @Column(name = "research_duty")
    private Long researchDuty;
    
    @Column(name = "the_type")
    private Long theType;
    
    @Column(name = "staff_property_id")
    private Long staffPropertyId;
    
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
