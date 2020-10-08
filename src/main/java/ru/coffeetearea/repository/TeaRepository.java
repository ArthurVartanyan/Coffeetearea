package ru.coffeetearea.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.coffeetearea.model.Tea;

public interface TeaRepository extends JpaRepository<Tea, Long>, JpaSpecificationExecutor<Tea> {

    Page<Tea> findAllByDeletedIsFalse(Pageable pageable);

    boolean existsByName(String teaName);
}