//package ru.coffeetearea.mappers;
//
//import org.mapstruct.IterableMapping;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;
//import ru.coffeetearea.DTO.catalogDTO.GeneralCatalogDTO;
//import ru.coffeetearea.model.catalog.GeneralCatalog;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring")
//public interface GeneralCatalogMapper {
//
//    GeneralCatalogMapper INSTANCE = Mappers.getMapper(GeneralCatalogMapper.class);
//
//    GeneralCatalogDTO catalogToCatalogDTO(GeneralCatalog generalCatalog);
//
//    GeneralCatalog catalogDTOtoCatalog(GeneralCatalogDTO generalCatalogDTO);
//
//    @IterableMapping(qualifiedByName = "catalogToCatalogDTO")
//    List<GeneralCatalogDTO> catalogsToCatalogsDTO(List<GeneralCatalog> generalCatalogs);
//}
