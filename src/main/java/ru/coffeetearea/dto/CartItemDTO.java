package ru.coffeetearea.dto;

import lombok.Data;
import ru.coffeetearea.model.Drink;

@Data
public class CartItemDTO {

    private Drink drink;

    private int count;
}