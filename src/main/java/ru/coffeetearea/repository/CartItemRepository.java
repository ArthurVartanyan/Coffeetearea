package ru.coffeetearea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffeetearea.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem removeByDrinkId(Long id);
}
