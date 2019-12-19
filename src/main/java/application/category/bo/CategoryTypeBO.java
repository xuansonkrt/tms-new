package application.category.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "category_type")
public class CategoryTypeBO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "code")
    private String code;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "effect_date")
    private Date effectDate;
    
    @Column(name = "expired_date")
    private Date expiredDate;
    
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
