package ru.coffeetearea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.Order;
import ru.coffeetearea.model.OrderStatus;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByUserIdAndOrderStatus(Long id, OrderStatus orderStatus);

    List<Order> findAllByUserId(Long id);
}