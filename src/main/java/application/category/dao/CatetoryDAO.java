package application.category.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import application.category.bo.CategoryBO;

public interface CatetoryDAO extends JpaRepository<CategoryBO, Long> {

}
