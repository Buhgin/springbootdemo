package ru.username.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.username.springbootdemo.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
