package ru.coffeetearea.repository.catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.catalog.Packaging;

public interface PackagingRepository extends JpaRepository<Packaging, Long> {
}
