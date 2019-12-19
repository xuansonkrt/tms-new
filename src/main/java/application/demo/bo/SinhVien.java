package application.demo.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;





@Entity(name = "sinhvien")
public class SinhVien {
   // @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "quequan")
    private String queQuan;

    @Column(name = "gioitinh")
    private int gioiTinh;
    
    @Column(name = "ngaysinh")
    private Date ngaySinh;
    
    @Column(name = "idlopcn")
    private int idLopCN;

    @Transient
    private MultipartFile file;
    
    
    
    public MultipartFile getFile() {
        return file; 
    }


    
    public void setFile(MultipartFile file) {
        this.file = file;
    }


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

    
    public String getQueQuan() {
        return queQuan;
    }

    
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    
    public int getGioiTinh() {
        return gioiTinh;
    }

    
    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    
    public Date getNgaySinh() {
        return ngaySinh;
    }

    
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    
    public int getIdLopCN() {
        return idLopCN;
    }

    
    public void setIdLopCN(int idLopCN) {
        this.idLopCN = idLopCN;
    }


}
