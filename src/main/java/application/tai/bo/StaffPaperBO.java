package application.tai.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff_paper")
public class StaffPaperBO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "staff_id")
    private Long staffId;
    
    @Column(name = "code")
    private String code;
    
    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "number_author")
    private Long numberAuthor;

    @Column(name = "publish_date")
    private Date publishDate;

    @Column(name = "term")
    private Long term;
    
    @Column(name = "year")
    private Long year;
    
    @Column(name = "research_point")
    private Double researchPoint;
    
    @Column(name = "organization_id")
    private Long organizationId;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "modified_by")
    private Long modifiedBy;

    @Column(name = "paper_type_id")
    private Long paperTypeId;
    
    
    
    
    
    public Long getPaperTypeId() {
        return paperTypeId;
    }


    
    public void setPaperTypeId(Long paperTypeId) {
        this.paperTypeId = paperTypeId;
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

    
    public String getAuthor() {
        return author;
    }

    
    public void setAuthor(String author) {
        this.author = author;
    }

    
    public Long getNumberAuthor() {
        return numberAuthor;
    }

    
    public void setNumberAuthor(Long numberAuthor) {
        this.numberAuthor = numberAuthor;
    }

    
    public Date getPublishDate() {
        return publishDate;
    }

    
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
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



    public Double getResearchPoint() {
        return researchPoint;
    }


    
    public void setResearchPoint(Double researchPoint) {
        this.researchPoint = researchPoint;
    }
    
    
    
}
