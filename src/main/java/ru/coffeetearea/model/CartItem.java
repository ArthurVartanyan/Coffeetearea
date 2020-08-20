package ru.coffeetearea.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Класс Корзина.
 * Сюда добавляются товары из магазина, для дальнейшего оформления.
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "cart_items")
public class CartItem {

    /**
     * Внутренний статический класс
     */
    @Data
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CartId implements Serializable {

        private Long order_id;

        private Long drink_id;
    }


    /**
     * Создан ключ через @EmbeddedId
     */
    @EmbeddedId
    private CartId cartId;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "drink_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    private Drink drink;

    /**
     * Кол-во товаров в корзине
     */
    private int count;
}