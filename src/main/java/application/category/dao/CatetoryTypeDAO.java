package application.category.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import application.category.bo.CategoryTypeBO;

public interface CatetoryTypeDAO extends JpaRepository<CategoryTypeBO, Long> {

}
