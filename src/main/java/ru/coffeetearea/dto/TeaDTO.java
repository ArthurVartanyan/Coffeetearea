package ru.coffeetearea.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.coffeetearea.model.catalog.TeaColor;
import ru.coffeetearea.model.catalog.TeaType;

@EqualsAndHashCode(callSuper = true)
@Data
public class TeaDTO extends DrinkDTO {

    private TeaType teaType;

    private TeaColor teaColor;
}