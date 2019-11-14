package application.demo.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity(name = "hocphan")
public class HocPhan {
   // @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "sotinchi")
    private int soTinChi;

    
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

    
    public int getSoTinChi() {
        return soTinChi;
    }

    
    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    
    

    
    
}
