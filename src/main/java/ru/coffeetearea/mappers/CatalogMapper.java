package ru.coffeetearea.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.coffeetearea.dto.GeneralCatalogDTO;
import ru.coffeetearea.model.catalog.GeneralCatalog;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatalogMapper {

    CatalogMapper INSTANCE = Mappers.getMapper(CatalogMapper.class);

    GeneralCatalogDTO catalogToCatalogsDTO(GeneralCatalog generalCatalog);

    @IterableMapping(qualifiedByName = "catalogToCatalogDTO")
    List<GeneralCatalogDTO> catalogsToCatalogsDTO(List<? extends GeneralCatalog> catalogs);
}