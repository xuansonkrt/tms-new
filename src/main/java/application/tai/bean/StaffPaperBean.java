package application.tai.bean;

import java.util.Date;

public class StaffPaperBean {
    private Long id;
    private Long staffId;
    private String code;
    private String name;
    private String author;
    private Long numberAuthor;
    private Date publishDate;
    private String publishDateString;
    private Long term;
    private Long year;
    private Long organizationId;
    private Date createdDate;
    private Date editedDate;
    private String createdBy;
    private String editedBy;
    private Double researchPoint;
    private Long paperTypeId;
    private String paperTypeName;
    
    
    
    
    
    public String getPaperTypeName() {
        return paperTypeName;
    }



    
    public void setPaperTypeName(String paperTypeName) {
        this.paperTypeName = paperTypeName;
    }



    public Long getPaperTypeId() {
        return paperTypeId;
    }


    
    public void setPaperTypeId(Long paperTypeId) {
        this.paperTypeId = paperTypeId;
    }


    public Double getResearchPoint() {
        return researchPoint;
    }

    
    public void setResearchPoint(Double researchPoint) {
        this.researchPoint = researchPoint;
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
    
    public String getPublishDateString() {
        return publishDateString;
    }
    
    public void setPublishDateString(String publishDateString) {
        this.publishDateString = publishDateString;
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
    
    public Date getEditedDate() {
        return editedDate;
    }
    
    public void setEditedDate(Date editedDate) {
        this.editedDate = editedDate;
    }
    
    public String getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    public String getEditedBy() {
        return editedBy;
    }
    
    public void setEditedBy(String editedBy) {
        this.editedBy = editedBy;
    }
    
    
}
