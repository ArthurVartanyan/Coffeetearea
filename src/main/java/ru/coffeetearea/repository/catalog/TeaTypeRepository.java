package ru.coffeetearea.repository.catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.catalog.Packaging;
import ru.coffeetearea.model.catalog.TeaType;

public interface TeaTypeRepository extends JpaRepository<TeaType, Long> {
}
