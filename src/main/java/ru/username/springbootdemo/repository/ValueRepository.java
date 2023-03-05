package ru.username.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.username.springbootdemo.model.Value;

public interface ValueRepository extends JpaRepository<Value,Long> {
}
