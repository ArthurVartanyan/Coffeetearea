package ru.coffeetearea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}