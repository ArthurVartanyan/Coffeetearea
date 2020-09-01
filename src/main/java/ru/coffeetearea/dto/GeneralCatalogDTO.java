package ru.coffeetearea.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class GeneralCatalogDTO {

    public interface New{

    }

    @Null(groups = {GeneralCatalogDTO.New.class})
    private Long id;

    @NotNull(groups = {GeneralCatalogDTO.New.class})
    private String name;
}