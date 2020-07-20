package ru.coffeetearea.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Order {

    public Order(){ // Constructor for Hibernate

    }


    // Fields
    //
    private @Id
    @GeneratedValue
    Long id;

    private String address;

    private String phoneNumber;

    private Date dateOrder;

    private OrderStatus orderStatus;

    private float totalCost;

    private User user;
}