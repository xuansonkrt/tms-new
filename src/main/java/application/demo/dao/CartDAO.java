package application.demo.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import application.demo.bo.CartBO;

public interface CartDAO extends CrudRepository<CartBO,Integer>{
    @Query("SELECT p FROM dbo_cart p ")
    List<CartBO> getAll();
}
