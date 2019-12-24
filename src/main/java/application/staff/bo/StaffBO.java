package application.staff.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "staff")
public class StaffBO {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;
    
    @Column(name = "code")
    private String code;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "gender")
    private Long gender;
    
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "user_name")
    private String userName;
    
    @Column(name = "password_hash")
    private String passwordHash;
    
    @Transient
    private String password;
    
    @Column(name = "organization_id")
    private Long organizationId;
    
    
    @Column(name = "army_rank_id")
    private Long armyRankId;
    
    @Column(name = "academic_level_id")
    private Long academicLevelId;
    
    @Column(name = "academic_title_id")
    private Long academicTitleId;
    
    @Column(name = "level_title_id")
    private Long levelTitleId;
    
    @Column(name = "avatar")
    private String avatar;
    
    @Column(name = "manager")
    private Long manager;
    
    @Column(name = "teaching")
    private Long teaching;
    
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

    
    public Long getGender() {
        return gender;
    }

    
    public void setGender(Long gender) {
        this.gender = gender;
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

    
    public String getUserName() {
        return userName;
    }

    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    public String getPasswordHash() {
        return passwordHash;
    }

    
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    
    public String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

    
    public Long getOrganizationId() {
        return organizationId;
    }

    
    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    
    public Long getArmyRankId() {
        return armyRankId;
    }

    
    public void setArmyRankId(Long armyRankId) {
        this.armyRankId = armyRankId;
    }

    
    public Long getAcademicLevelId() {
        return academicLevelId;
    }

    
    public void setAcademicLevelId(Long academicLevelId) {
        this.academicLevelId = academicLevelId;
    }

    
    public Long getAcademicTitleId() {
        return academicTitleId;
    }

    
    public void setAcademicTitleId(Long academicTitleId) {
        this.academicTitleId = academicTitleId;
    }

    
    public Long getLevelTitleId() {
        return levelTitleId;
    }

    
    public void setLevelTitleId(Long levelTitleId) {
        this.levelTitleId = levelTitleId;
    }

    
    public String getAvatar() {
        return avatar;
    }

    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    
    public Long getManager() {
        return manager;
    }

    
    public void setManager(Long manager) {
        this.manager = manager;
    }

    
    public Long getTeaching() {
        return teaching;
    }

    
    public void setTeaching(Long teaching) {
        this.teaching = teaching;
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


    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }


    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    
}
