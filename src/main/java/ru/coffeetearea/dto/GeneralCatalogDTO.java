package ru.coffeetearea.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@NoArgsConstructor
public class GeneralCatalogDTO {

    public interface New{

    }

    public interface Edit{

    }

    @Null(groups = {GeneralCatalogDTO.New.class})
    @NotNull(groups = {GeneralCatalogDTO.Edit.class})
    private Long id;

    @NotNull(groups = {GeneralCatalogDTO.New.class})
    private String name;
}