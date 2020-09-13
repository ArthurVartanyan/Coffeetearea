package ru.coffeetearea.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.coffeetearea.model.catalog.GeneralCatalog;
import ru.coffeetearea.model.catalog.TeaColor;
import ru.coffeetearea.model.catalog.TeaType;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TeaDTO extends DrinkDTO {

    @NotNull(groups = {New.class, Edit.class})
    private GeneralCatalogDTO teaType;

    @NotNull(groups = {New.class, Edit.class})
    private GeneralCatalogDTO teaColor;
}