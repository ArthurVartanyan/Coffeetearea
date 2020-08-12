package ru.coffeetearea.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.coffeetearea.model.catalog.TeaColor;
import ru.coffeetearea.model.catalog.TeaType;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeaDTO extends DrinkDTO {

    private TeaType teaType;

    private TeaColor teaColor;
}