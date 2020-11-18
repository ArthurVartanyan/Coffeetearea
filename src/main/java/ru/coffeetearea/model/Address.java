package ru.coffeetearea.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pg_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "region")
    private String region;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private short house;

    @Column(name = "apartment")
    private short apartment;

    @Column(name = "index")
    private int index;
}