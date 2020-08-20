package ru.coffeetearea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.CartItem;
import ru.coffeetearea.model.Order;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem getByOrderAndDrinkId(Order order, Long id);
}