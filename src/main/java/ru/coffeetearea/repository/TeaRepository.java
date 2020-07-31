package ru.coffeetearea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.coffeetearea.model.Tea;

public interface TeaRepository extends JpaRepository<Tea, Long>, JpaSpecificationExecutor<Tea> {
}