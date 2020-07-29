package ru.coffeetearea.repository.catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.catalog.Countries;

public interface CountriesRepository extends JpaRepository<Countries, Long> {
}