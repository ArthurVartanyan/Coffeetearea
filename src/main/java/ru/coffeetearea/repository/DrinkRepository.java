package ru.coffeetearea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.coffeetearea.model.Drink;

public interface DrinkRepository extends JpaRepository<Drink, Long>, JpaSpecificationExecutor<Drink> {

}