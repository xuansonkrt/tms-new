package application.category.form;

import java.util.Date;

public class CategoryForm {
    private Long id;
    private String code;
    private String name;
    private Date effectDate;
    private Date expiredDate;
    private String effectDateShow;
    private String expiredDateShow;
    private Date createdDate;
    private Long createdBy;
    private Date modifiedDate;
    private Long modifiedBy;
    private Long categoryTypeId;
    private Long theOrder;
    

    public Long getTheOrder() {
        return theOrder;
    }


    
    public void setTheOrder(Long theOrder) {
        this.theOrder = theOrder;
    }


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
    
    public Date getEffectDate() {
        return effectDate;
    }
    
    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }
    
    public Date getExpiredDate() {
        return expiredDate;
    }
    
    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }
    
    public String getEffectDateShow() {
        return effectDateShow;
    }
    
    public void setEffectDateShow(String effectDateShow) {
        this.effectDateShow = effectDateShow;
    }
    
    public String getExpiredDateShow() {
        return expiredDateShow;
    }
    
    public void setExpiredDateShow(String expiredDateShow) {
        this.expiredDateShow = expiredDateShow;
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
    
    public Long getCategoryTypeId() {
        return categoryTypeId;
    }
    
    public void setCategoryTypeId(Long categoryTypeId) {
        this.categoryTypeId = categoryTypeId;
    }
    
    
}
