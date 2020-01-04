package application.user.form;


public class UserForm {
    private String userName;
    private String password;
    private String passwordOld;
    private String passwordNew;
    
    
    
    
    public String getPasswordOld() {
        return passwordOld;
    }

    
    public void setPasswordOld(String passwordOld) {
        this.passwordOld = passwordOld;
    }

    
    public String getPasswordNew() {
        return passwordNew;
    }

    
    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }

    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
