package ru.coffeetearea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.Tea;

public interface TeaRepository extends JpaRepository<Tea, Long> {
}