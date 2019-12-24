package application.organization.form;

import java.util.Date;

public class OrganizationForm {

    private Long id;
    private String code;
    private String name;
    private String note;
    private String phoneNumber;
    private String email;
    private String address;
    private Long parentId;
    private String path;
    private Long level;
    private Long theOrder;
    private Date foundedDate;
    private Date createdDate;
    private Long createdBy;
    private Date modifiedDate;
    private Long modifiedBy;
    private String foundedDateShow;
    private String parentName;
    
    
    
    public String getNote() {
        return note;
    }


    
    public void setNote(String note) {
        this.note = note;
    }


    public String getParentName() {
        return parentName;
    }

    
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getFoundedDateShow() {
        return foundedDateShow;
    }

    public void setFoundedDateShow(String foundedDateShow) {
        this.foundedDateShow = foundedDateShow;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getTheOrder() {
        return theOrder;
    }

    public void setTheOrder(Long theOrder) {
        this.theOrder = theOrder;
    }

    public Date getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(Date foundedDate) {
        this.foundedDate = foundedDate;
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
