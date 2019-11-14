package application.demo.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity(name = "lophocphan")
public class LopHocPhan {
   // @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "idhocky")
    private int idHocKy;
    
    @Column(name = "idhocphan")
    private int idHocPhan;

    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public String getMa() {
        return ma;
    }

    
    public void setMa(String ma) {
        this.ma = ma;
    }

    
    public String getTen() {
        return ten;
    }

    
    public void setTen(String ten) {
        this.ten = ten;
    }

    
    public int getIdHocKy() {
        return idHocKy;
    }

    
    public void setIdHocKy(int idHocKy) {
        this.idHocKy = idHocKy;
    }

    
    public int getIdHocPhan() {
        return idHocPhan;
    }

    
    public void setIdHocPhan(int idHocPhan) {
        this.idHocPhan = idHocPhan;
    }

    

    
    
}
