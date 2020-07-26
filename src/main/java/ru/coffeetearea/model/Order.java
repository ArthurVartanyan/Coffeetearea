package ru.coffeetearea.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Класс: Заказ
 * Содержит поля: id(ИД), address(адрес), phoneNumber(номер телефона), dateOrder(дата заказа),
 * orderStatus(статус заказа), totalCost(общая стоимость всех товаров в заказе).
 * Через связи есть поля user(заказчик).
 */

@Entity
@Table(name = "pg_order")
public class Order {

    // Fields
    //
    private @Id
    @GeneratedValue
    Long id;

    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_order")
    private Date dateOrder;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    // Relationships
    //
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}