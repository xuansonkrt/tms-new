package application.category.form;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import application.config.CustomDateSerializer;

public class CategoryTypeForm {
    private Long id;
    private String code;
    private String name;
    private String effectDate;
    private String expiredDate;
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
    
    public String getEffectDate() {
        return effectDate;
    }
    
    public void setEffectDate(String effectDate) {
        this.effectDate = effectDate;
    }
    
    public String getExpiredDate() {
        return expiredDate;
    }
    
    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
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
