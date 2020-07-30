package ru.coffeetearea.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/*
Класс Корзина. Сюда добавляются товары из магазина, для дальнейшего оформления.
 */

@Data
@Entity
@NoArgsConstructor
@Table(name = "cart_products")
public class Cart {

    /* Внутренний статический класс */
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    static class CartId implements Serializable {

        private Long order_id;

        private Long drink_id;
    }


    // Fields
    //
    @EmbeddedId
    private CartId cartId;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id",
            insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "drink_id", referencedColumnName = "id",
            insertable = false, updatable = false)
    private Drink drink;

    /* Кол-во товаров в корзине */
    private int count;
}