package ru.coffeetearea.repository.catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.catalog.CoffeeType;

public interface CoffeeTypeRepository extends JpaRepository<CoffeeType, Long> {
}