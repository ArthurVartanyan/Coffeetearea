package ru.coffeetearea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}