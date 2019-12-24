package application.staff.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * UserBean
 *
 * @author
 * @since 1.0
 * @version 1.0
 */
public class StaffBean implements UserDetails {

    private Long userId;
    private String userName;
    private String password;
    private String fullName;
    private Date dateOfBirth;
    private Long gender;
    private String email;
    private String mobileNumber;
    private Long positionId;
    private Long roleId;
    private String className;
    private String majorName;
    private String departmentName;
    private String userCode;
    private String role;
    private String roleName;
    private Long id;
    private String code;
    private String name;
    private String dateOfBirthShow;
    private String phoneNumber;
    private String address;
    private String passwordHash;
    private Long organizationId;
    private Long armyRankId;
    private Long academicLevelId;
    private Long academicTitleId;
    private Long levelTitleId;
    private String avatar;
    private Long manager;
    private Long teaching;
    private Date createdDate;
    private Long createdBy;
    private Date modifiedDate;
    private Long modifiedBy;

    private String academicLevelName;
    private String academicTitleName;
    private String armyRankName;
    private String levelTitleName;
    private String organizationName;
    
    
    
    public String getAcademicLevelName() {
        return academicLevelName;
    }

    
    public void setAcademicLevelName(String academicLevelName) {
        this.academicLevelName = academicLevelName;
    }

    
    public String getAcademicTitleName() {
        return academicTitleName;
    }

    
    public void setAcademicTitleName(String academicTitleName) {
        this.academicTitleName = academicTitleName;
    }

    
    public String getArmyRankName() {
        return armyRankName;
    }

    
    public void setArmyRankName(String armyRankName) {
        this.armyRankName = armyRankName;
    }

    
    public String getLevelTitleName() {
        return levelTitleName;
    }

    
    public void setLevelTitleName(String levelTitleName) {
        this.levelTitleName = levelTitleName;
    }

    
    public String getOrganizationName() {
        return organizationName;
    }

    
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }

    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    // // TODO Auto-generated method stub
    // return listGrantedAuthoritys;
    // }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @return the gender
     */
    public Long getGender() {
        return gender;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the mobileNumber
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @return the majorName
     */
    public String getMajorName() {
        return majorName;
    }

    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @return the userCode
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param fullName
     *            the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @param gender
     *            the gender to set
     */
    public void setGender(Long gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getDateOfBirthShow() {
        return dateOfBirthShow;
    }

    public void setDateOfBirthShow(String dateOfBirthShow) {
        this.dateOfBirthShow = dateOfBirthShow;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
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

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param mobileNumber
     *            the mobileNumber to set
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @param className
     *            the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @param majorName
     *            the majorName to set
     */
    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    /**
     * @param departmentName
     *            the departmentName to set
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * @param userCode
     *            the userCode to set
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /**
     * @return the roleId
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param roleId
     *            the roleId to set
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     *            the roleName to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * @return the postisionId
     */
    public Long getPositionId() {
        return positionId;
    }

    /**
     * @param postisionId
     *            the postisionId to set
     */
    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

}
