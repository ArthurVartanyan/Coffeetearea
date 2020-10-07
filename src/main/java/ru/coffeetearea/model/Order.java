package ru.coffeetearea.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "pg_order")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * Адрес доставки
     */
    @Column(name = "address")
    private String address;

    /**
     * Номер телефона заказчика
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * Дата заказа
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_order")
    private Date dateOrder;

    /**
     * Статус заказа (см. EnumType)
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    /**
     * Полная стоимость заказа
     */
    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOrder=" + dateOrder +
                ", orderStatus=" + orderStatus +
                ", totalCost=" + totalCost +
                ", user=" + user +
                ", cartItems=" + cartItems +
                '}';
    }
}