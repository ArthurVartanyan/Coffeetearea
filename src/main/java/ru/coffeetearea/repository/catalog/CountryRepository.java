package ru.coffeetearea.repository.catalog;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.coffeetearea.model.catalog.Country;
import ru.coffeetearea.model.catalog.GeneralCatalog;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long>, JpaSpecificationExecutor<Country> {

    List<GeneralCatalog> findAllByIsDeletedIsFalse(Sort sort);
}