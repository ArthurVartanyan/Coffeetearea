package ru.coffeetearea.repository.catalog;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.catalog.CoffeeType;
import ru.coffeetearea.model.catalog.GeneralCatalog;
import ru.coffeetearea.model.catalog.Manufacturer;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

    List<GeneralCatalog> findAllByDeletedIsFalse(Sort sort);

    boolean existsByName(String manufacturerName);
}