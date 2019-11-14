package application.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import application.demo.bo.HocLop;

public interface HocLopDAO extends JpaRepository<HocLop,Integer>{
   public HocLop findFirstByOrderByIdAsc();
}
