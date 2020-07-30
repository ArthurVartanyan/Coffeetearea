package ru.coffeetearea.service.catalog;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.coffeetearea.DTO.PageDTO.PageDTO;
import ru.coffeetearea.DTO.catalogDTO.GeneralCatalogDTO;
import ru.coffeetearea.mappers.CatalogMapper;
import ru.coffeetearea.repository.catalog.*;

@RequiredArgsConstructor
@Service
public class CatalogService {

    // Fields
    //
    private final CountriesRepository countriesRepository;

    private final ManufacturerRepository manufacturerRepository;

    private final RoastingRepository roastingRepository;

    private final PackagingRepository packagingRepository;

    private final TeaColorRepository teaColorRepository;

    private final CoffeeTypeRepository coffeeTypeRepository;

    private final TeaTypeRepository teaTypeRepository;

    private final CatalogMapper catalogMapper;


    /**
     * Получение списка стран
     *
     * @param page
     * @param pageSize
     * @return countries
     */
    public PageDTO<? extends GeneralCatalogDTO> findCountries(int page, int pageSize) {

        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("name"));

        return new PageDTO<>(catalogMapper
                .catalogsToCatalogsDTO(countriesRepository.findAll(pageRequest)));
    }

    /**
     * Получение списка производителей
     *
     * @param page
     * @param pageSize
     * @return manufacturers
     */
    public PageDTO<? extends GeneralCatalogDTO> findManufacturers(int page, int pageSize) {

        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("name"));

        return new PageDTO<>(catalogMapper
                .catalogsToCatalogsDTO(manufacturerRepository.findAll(pageRequest)));
    }

    /**
     * Получение списка обжарки
     *
     * @param page
     * @param pageSize
     * @return roasting
     */
    public PageDTO<? extends GeneralCatalogDTO> findRoastings(int page, int pageSize) {

        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("name"));

        return new PageDTO<>(catalogMapper.catalogsToCatalogsDTO(roastingRepository.findAll(pageRequest)));
    }

    /**
     * Получение списка упаковок
     *
     * @param page
     * @param pageSize
     * @return packages
     */
    public PageDTO<? extends GeneralCatalogDTO> findPackages(int page, int pageSize) {

        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("name"));

        return new PageDTO<>(catalogMapper.catalogsToCatalogsDTO(packagingRepository.findAll(pageRequest)));
    }

    /**
     * Получение списка цвета чая
     *
     * @param page
     * @param pageSize
     * @return tea colors
     */
    public PageDTO<? extends GeneralCatalogDTO> findTeaColors(int page, int pageSize) {

        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("name"));

        return new PageDTO<>(catalogMapper.catalogsToCatalogsDTO(teaColorRepository.findAll(pageRequest)));
    }

    /**
     * Получение списка типов кофе
     *
     * @param page
     * @param pageSize
     * @return coffee types
     */
    public PageDTO<? extends GeneralCatalogDTO> findCoffeeTypes(int page, int pageSize) {

        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("name"));

        return new PageDTO<>(catalogMapper.catalogsToCatalogsDTO(coffeeTypeRepository.findAll(pageRequest)));
    }

    /**
     * Получение списка типов чая
     *
     * @param page
     * @param pageSize
     * @return tea types
     */
    public PageDTO<? extends GeneralCatalogDTO> findTeaTypes(int page, int pageSize) {

        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("name"));

        return new PageDTO<>(catalogMapper.catalogsToCatalogsDTO(teaTypeRepository.findAll(pageRequest)));
    }
}