package ru.coffeetearea.repository.catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.catalog.TeaColor;

public interface TeaColorRepository extends JpaRepository<TeaColor, Long> {
}