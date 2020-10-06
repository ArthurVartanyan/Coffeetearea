package ru.coffeetearea.repository.catalog;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.catalog.GeneralCatalog;
import ru.coffeetearea.model.catalog.Packaging;

import java.util.List;

public interface PackagingRepository extends JpaRepository<Packaging, Long> {

    List<GeneralCatalog> findAllByIsDeletedIsFalse(Sort sort);
}