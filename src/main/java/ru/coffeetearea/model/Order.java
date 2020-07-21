package ru.coffeetearea.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pg_order", schema = "public")
public class Order {

    public Order() { // Constructor for Hibernate

    }


    // Fields
    //
    private @Id
    @GeneratedValue
    Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_order")
    private Date dateOrder;

    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Column(name = "total_cost")
    private float totalCost;

    // Relationships
    //
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}