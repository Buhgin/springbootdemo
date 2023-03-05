package ru.username.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.username.springbootdemo.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
