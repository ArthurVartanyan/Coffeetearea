package ru.coffeetearea.repository.catalog;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.catalog.GeneralCatalog;
import ru.coffeetearea.model.catalog.TeaColor;

import java.util.List;

public interface TeaColorRepository extends JpaRepository<TeaColor, Long> {

    List<GeneralCatalog> findAllByDeletedIsFalse(Sort sort);
}