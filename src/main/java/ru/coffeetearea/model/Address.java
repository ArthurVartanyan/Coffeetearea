package ru.coffeetearea.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Embeddable
public class Address {

    private String region;

    private String city;

    private String district;

    private String street;

    private short house;

    private short apartment;

    private int index;
}