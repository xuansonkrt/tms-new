package application.demo.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity(name = "dbo_cart")
public class CartBO {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    @Id
    private int id;

    @Column(name = "guid")
    private String guid;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "created_date")
    private Date createdDate;

    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public String getGuid() {
        return guid;
    }

    
    public void setGuid(String guid) {
        this.guid = guid;
    }

    
    public String getUserName() {
        return userName;
    }

    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    public Date getCreatedDate() {
        return createdDate;
    }

    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    
    
}
