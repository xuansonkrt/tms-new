package application.demo.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import application.demo.bo.LopHocPhan;

public interface LopHocPhanDAO extends JpaRepository<LopHocPhan,Integer>{
    
      @Query("SELECT p FROM lophocphan p ")
      List<LopHocPhan> getAll();
      
      
      public List<LopHocPhan> findByIdHocKy(int idHocKy);

      
}
