package ru.coffeetearea.dto;

import lombok.Data;
import ru.coffeetearea.model.CartItem;
import ru.coffeetearea.model.User;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
public class OrderDTO {

    private String address;

    private String phoneNumber;

    private Date dateOrder;

    private BigDecimal totalCost;

    private Set<CartItem> cartItem;
}