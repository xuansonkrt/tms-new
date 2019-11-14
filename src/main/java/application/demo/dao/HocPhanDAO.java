package application.demo.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import application.demo.bo.CartBO;
import application.demo.bo.HocPhan;

public interface HocPhanDAO extends CrudRepository<HocPhan,Integer>{
    
      @Query("SELECT p FROM hocphan p ")
      List<HocPhan> getAll();
     
}
