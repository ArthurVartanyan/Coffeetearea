package ru.coffeetearea.dto;

import lombok.Data;
import ru.coffeetearea.model.Drink;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Null;

@Data
public class CartItemDTO {

    public interface SetCount {

    }

    @Null(groups = {SetCount.class})
    private Drink drink;

    @Min(value = 1, groups = {SetCount.class})
    @Max(value = 100, groups = {SetCount.class})
    private int count;
}