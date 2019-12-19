package application.demo.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import application.demo.bo.SinhVien;

public interface SinhVienDAO extends JpaRepository<SinhVien,Integer>{
    
      @Query("SELECT p FROM sinhvien p ")
      List<SinhVien> getAll();
     
      public List<SinhVien> findByIdLopCN(int idLopChuyenNganh);
}
