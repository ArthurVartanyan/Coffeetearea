package ru.coffeetearea.dto;

import lombok.Data;
import ru.coffeetearea.model.OrderStatus;
import ru.coffeetearea.model.User;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderInfoDTO {

    private Long id;

    /**
     * Адрес доставки
     */
    private String address;

    /**
     * Номер телефона заказчика
     */
    private String phoneNumber;

    /**
     * Дата заказа
     */
    private Date dateOrder;

    /**
     * Статус заказа (см. EnumType)
     */
    private OrderStatus orderStatus;

    /**
     * Полная стоимость заказа
     */
    private BigDecimal totalCost;

    private UserDTO userDTO;
}