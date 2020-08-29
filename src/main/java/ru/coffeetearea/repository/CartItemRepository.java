package ru.coffeetearea.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.coffeetearea.model.CartItem;
import ru.coffeetearea.model.Order;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem getByOrderAndDrinkId(Order order, Long id);

    /*
    Возвращает самые популярные напитки по убыванию
     */
    @Query("select C.drink.id, sum(C.count) as count from CartItem C where C.order.orderStatus = 'ACTIVE' group by C.drink order by 2 DESC")
    List<Long> getMostPopularDrinksIds(Pageable pageable);
}