package application.demo.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity(name = "hoclop")
public class HocLop {
   // @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "idsinhvien")
    private int idSinhVien;

    @Column(name = "idlophocphan")
    private int idLopHocPhan;

    @Column(name = "diemcc")
    private String diemCC;
    
    @Column(name = "diemtx")
    private String diemTX;
    
    @Column(name = "diemthi")
    private String diemThi;
    
    @Column(name = "diemtb")
    private Double diemTB;

    @Column(name = "diembangchu")
    private String diemBangChu;
    
    @Column(name = "diemhs4")
    private Double diemHS4;

    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public int getIdSinhVien() {
        return idSinhVien;
    }

    
    public void setIdSinhVien(int idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    
    public int getIdLopHocPhan() {
        return idLopHocPhan;
    }

    
    public void setIdLopHocPhan(int idLopHocPhan) {
        this.idLopHocPhan = idLopHocPhan;
    }

    
    public String getDiemCC() {
        return diemCC;
    }

    
    public void setDiemCC(String diemCC) {
        this.diemCC = diemCC;
    }

    
    public String getDiemTX() {
        return diemTX;
    }

    
    public void setDiemTX(String diemTX) {
        this.diemTX = diemTX;
    }

    
    public String getDiemThi() {
        return diemThi;
    }

    
    public void setDiemThi(String diemThi) {
        this.diemThi = diemThi;
    }

    
    public Double getDiemTB() {
        return diemTB;
    }

    
    public void setDiemTB(Double diemTB) {
        this.diemTB = diemTB;
    }

    
    public String getDiemBangChu() {
        return diemBangChu;
    }

    
    public void setDiemBangChu(String diemBangChu) {
        this.diemBangChu = diemBangChu;
    }

    
    public Double getDiemHS4() {
        return diemHS4;
    }

    
    public void setDiemHS4(Double diemHS4) {
        this.diemHS4 = diemHS4;
    }
    
    
    
}
