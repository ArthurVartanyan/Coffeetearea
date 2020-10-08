package ru.coffeetearea.repository.catalog;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.catalog.CoffeeType;
import ru.coffeetearea.model.catalog.GeneralCatalog;

import java.util.List;

public interface CoffeeTypeRepository extends JpaRepository<CoffeeType, Long> {

    List<GeneralCatalog> findAllByDeletedIsFalse(Sort sort);

    boolean existsByName(String coffeeTypeName);
}