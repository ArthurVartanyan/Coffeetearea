package ru.coffeetearea.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import ru.coffeetearea.DTO.catalogDTO.GeneralCatalogDTO;
import ru.coffeetearea.model.catalog.GeneralCatalog;

@Mapper(componentModel = "spring")
public interface CatalogMapper {

    CatalogMapper INSTANCE = Mappers.getMapper(CatalogMapper.class);

    GeneralCatalogDTO catalogToCatalogsDTO(GeneralCatalog generalCatalog);

    @IterableMapping(qualifiedByName = "catalogToDrinkDTO")
    default Page<GeneralCatalogDTO> catalogsToCatalogsDTO(Page<? extends GeneralCatalog> catalogs) {

        return catalogs.map(this::catalogToCatalogsDTO);
    }
}