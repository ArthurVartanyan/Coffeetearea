package ru.coffeetearea.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "pg_order")
public class Order {

    // Fields
    //
    @Id
    @GeneratedValue
    private Long id;

    /** Адрес доставки */
    private String address;

    /** Номер телефона заказчика */
    @Column(name = "phone_number")
    private String phoneNumber;

    /** Дата заказа */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_order")
    private Date dateOrder;

    /** Статус заказа (см. EnumType) */
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    /** Полная стоимость заказа */
    @Column(name = "total_cost")
    private BigDecimal totalCost;

    // Relationships
    //
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private Set<Cart> cart;
}