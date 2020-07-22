package ru.coffeetearea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}