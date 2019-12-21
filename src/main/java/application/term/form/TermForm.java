package application.term.form;

import java.util.Date;

public class TermForm {

    private Long id;
    private String code;
    private String name;
    private Long year;
    private Date beginDate;
    private Date endDate;
    private String beginDateShow;
    private String endDateShow;
    private Long theOrder;
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
    
    public Long getYear() {
        return year;
    }
    
    public void setYear(Long year) {
        this.year = year;
    }
    
    public Date getBeginDate() {
        return beginDate;
    }
    
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }
    
    public Date getEndDate() {
        return endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public Long getTheOrder() {
        return theOrder;
    }
    
    public void setTheOrder(Long theOrder) {
        this.theOrder = theOrder;
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

    
    public String getBeginDateShow() {
        return beginDateShow;
    }

    
    public void setBeginDateShow(String beginDateShow) {
        this.beginDateShow = beginDateShow;
    }

    
    public String getEndDateShow() {
        return endDateShow;
    }

    
    public void setEndDateShow(String endDateShow) {
        this.endDateShow = endDateShow;
    }
    
    
}
