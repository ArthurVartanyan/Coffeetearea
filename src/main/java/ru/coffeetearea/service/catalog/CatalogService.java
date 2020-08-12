package ru.coffeetearea.service.catalog;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.coffeetearea.dto.GeneralCatalogDTO;
import ru.coffeetearea.mappers.CatalogMapper;
import ru.coffeetearea.repository.catalog.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final CountryRepository countriesRepository;

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
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findCountries() {
        return catalogMapper.catalogsToCatalogsDTO(countriesRepository.findAll(Sort.by("name").ascending()));
    }

    /**
     * Получение списка производителей
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findManufacturers() {
        return catalogMapper.catalogsToCatalogsDTO(manufacturerRepository.findAll(Sort.by("name").ascending()));
    }

    /**
     * Получение списка обжарки
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findRoastings() {
        return catalogMapper.catalogsToCatalogsDTO(roastingRepository.findAll(Sort.by("name").ascending()));
    }

    /**
     * Получение списка упаковок
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findPackages() {
        return catalogMapper.catalogsToCatalogsDTO(packagingRepository.findAll(Sort.by("name").ascending()));
    }

    /**
     * Получение списка цвета чая
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findTeaColors() {
        return catalogMapper.catalogsToCatalogsDTO(teaColorRepository.findAll(Sort.by("name").ascending()));
    }

    /**
     * Получение списка типов кофе
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findCoffeeTypes() {
        return catalogMapper.catalogsToCatalogsDTO(coffeeTypeRepository.findAll(Sort.by("name").ascending()));
    }

    /**
     * Получение списка типов чая
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findTeaTypes() {
        return catalogMapper.catalogsToCatalogsDTO(teaTypeRepository.findAll(Sort.by("name").ascending()));
    }
}