package ru.coffeetearea.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderDTO {

    private Long id;

    private String address;

    private String phoneNumber;

    private Date dateOrder;

    private BigDecimal totalCost;
}