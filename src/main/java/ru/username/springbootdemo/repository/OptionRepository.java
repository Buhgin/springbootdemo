package ru.username.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.username.springbootdemo.model.Option;

public interface OptionRepository extends JpaRepository<Option,Long> {
}
