package ru.coffeetearea.repository.catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.catalog.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}
