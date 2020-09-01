package ru.coffeetearea.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.coffeetearea.model.catalog.TeaColor;
import ru.coffeetearea.model.catalog.TeaType;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeaDTO extends DrinkDTO {

    @NotNull(groups = {New.class})
    private TeaType teaType;

    @NotNull(groups = {New.class})
    private TeaColor teaColor;
}