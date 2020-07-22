package ru.coffeetearea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}