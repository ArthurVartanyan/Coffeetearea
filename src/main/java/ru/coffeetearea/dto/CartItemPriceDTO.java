package ru.coffeetearea.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CartItemPriceDTO {

    private List<CartItemDTO> cartItemDTOS;

    private BigDecimal OrderPrice;
}