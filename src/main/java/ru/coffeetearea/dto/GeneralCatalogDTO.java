package ru.coffeetearea.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@NoArgsConstructor
public class GeneralCatalogDTO {

    public interface New {

    }

    public interface Edit {

    }

    @Null(groups = {GeneralCatalogDTO.New.class})
    private Long id;

    @NotBlank(groups = {GeneralCatalogDTO.New.class, GeneralCatalogDTO.Edit.class})
    private String name;
}