package ru.coffeetearea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.Order;
import ru.coffeetearea.model.OrderStatus;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByUserIdAndOrderStatus(Long id, OrderStatus orderStatus);

    boolean existsByUserIdAndOrderStatus(Long id, OrderStatus orderStatus);
}