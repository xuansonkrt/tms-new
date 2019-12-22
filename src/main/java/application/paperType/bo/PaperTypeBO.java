package application.paperType.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paper_type")
public class PaperTypeBO {
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
    
    @Column(name = "paper_level_id")
    private Long paperLevelId;

    @Column(name = "research_point")
    private Double researchPoint;
    
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

    
    public Long getPaperLevelId() {
        return paperLevelId;
    }


    
    public void setPaperLevelId(Long paperLevelId) {
        this.paperLevelId = paperLevelId;
    }


    public Double getResearchPoint() {
        return researchPoint;
    }

    
    public void setResearchPoint(Double researchPoint) {
        this.researchPoint = researchPoint;
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
