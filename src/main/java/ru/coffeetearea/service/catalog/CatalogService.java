package ru.coffeetearea.service.catalog;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.coffeetearea.dto.GeneralCatalogDTO;
import ru.coffeetearea.exceptions.BadRequestException;
import ru.coffeetearea.exceptions.EntityNotFoundException;
import ru.coffeetearea.mappers.CatalogMapper;
import ru.coffeetearea.model.catalog.*;
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
     * Редактирование элементов типов кофе
     */
    public GeneralCatalogDTO editCoffeeType(Long coffeeTypeId, String name) {

        CoffeeType coffeeType = coffeeTypeRepository
                .findById(coffeeTypeId)
                .orElseThrow(() -> new EntityNotFoundException(coffeeTypeId));

        if (!coffeeTypeRepository.existsByName(name)) {

            coffeeType.setName(name);
            coffeeTypeRepository.save(coffeeType);

            return catalogMapper.catalogToCatalogsDTO(coffeeType);

        } else {
            throw new BadRequestException("Ошибка! Тип кофе с таким названием уже существует!");
        }

    }

    /**
     * Редактирование элементов стран
     */
    public GeneralCatalogDTO editCountry(Long countryId, String name) {

        Country country = countriesRepository
                .findById(countryId)
                .orElseThrow(() -> new EntityNotFoundException(countryId));

        if (!countriesRepository.existsByName(name)) {

            country.setName(name);
            countriesRepository.save(country);

            return catalogMapper.catalogToCatalogsDTO(country);

        } else {
            throw new BadRequestException("Ошибка! Страна с таким названием уже существует!");
        }

    }


    /**
     * Редактирование элементов типов производителей
     */
    public GeneralCatalogDTO editManufacturer(Long manufacturerId, String name) {

        Manufacturer manufacturer = manufacturerRepository
                .findById(manufacturerId)
                .orElseThrow(() -> new EntityNotFoundException(manufacturerId));

        if (!manufacturerRepository.existsByName(name)) {

            manufacturer.setName(name);
            manufacturerRepository.save(manufacturer);

            return catalogMapper.catalogToCatalogsDTO(manufacturer);

        } else {
            throw new BadRequestException("Ошибка! Производитель с таким названием уже существует!");
        }

    }


    /**
     * Редактирование элементов типов пакетов
     */
    public GeneralCatalogDTO editPackaging(Long packagingId, String name) {

        Packaging packaging = packagingRepository
                .findById(packagingId)
                .orElseThrow(() -> new EntityNotFoundException(packagingId));

        if (!packagingRepository.existsByName(name)) {

            packaging.setName(name);
            packagingRepository.save(packaging);

            return catalogMapper.catalogToCatalogsDTO(packaging);

        } else {
            throw new BadRequestException("Ошибка! Упаковка с таким названием уже существует!");
        }

    }


    /**
     * Редактирование элементов типов обжарки
     */
    public GeneralCatalogDTO editRoasting(Long roastingId, String name) {

        Roasting roasting = roastingRepository
                .findById(roastingId)
                .orElseThrow(() -> new EntityNotFoundException(roastingId));

        if (!roastingRepository.existsByName(name)) {

            roasting.setName(name);
            roastingRepository.save(roasting);

            return catalogMapper.catalogToCatalogsDTO(roasting);

        } else {
            throw new BadRequestException("Ошибка! Прожарка с таким названием уже существует!");
        }

    }


    /**
     * Редактирование элементов цветов чая
     */
    public GeneralCatalogDTO editTeaColor(Long teaColorId, String name) {

        TeaColor teaColor = teaColorRepository
                .findById(teaColorId)
                .orElseThrow(() -> new EntityNotFoundException(teaColorId));

        if (!teaColorRepository.existsByName(name)) {

            teaColor.setName(name);
            teaColorRepository.save(teaColor);

            return catalogMapper.catalogToCatalogsDTO(teaColor);

        } else {
            throw new BadRequestException("Ошибка! Цвет чая с таким названием уже существует!");
        }

    }

    /**
     * Редактирование элементов типов чая
     */
    public GeneralCatalogDTO editTeaType(Long teaTypeId, String name) {

        TeaType teaType = teaTypeRepository
                .findById(teaTypeId)
                .orElseThrow(() -> new EntityNotFoundException(teaTypeId));

        if (!teaTypeRepository.existsByName(name)) {

            teaType.setName(name);
            teaTypeRepository.save(teaType);

            return catalogMapper.catalogToCatalogsDTO(teaType);

        } else {
            throw new BadRequestException("Ошибка! Тип чая с таким названием уже существует!");
        }

    }


    /**
     * Создание элементов типов кофе
     */
    public GeneralCatalogDTO addCoffeeType(String name) {

        if (!coffeeTypeRepository.existsByName(name)) {

            CoffeeType coffeeType = new CoffeeType();
            coffeeType.setDeleted(false);
            coffeeType.setName(name);
            coffeeTypeRepository.save(coffeeType);

            return catalogMapper.catalogToCatalogsDTO(coffeeType);

        } else {
            throw new BadRequestException("Ошибка! Тип кофе с таким названием уже существует!");
        }
    }

    /**
     * Создание элементов стран
     */
    public GeneralCatalogDTO addCountry(String name) {

        if (!countriesRepository.existsByName(name)) {

            Country country = new Country();
            country.setDeleted(false);
            country.setName(name);
            countriesRepository.save(country);

            return catalogMapper.catalogToCatalogsDTO(country);

        } else {
            throw new BadRequestException("Ошибка! Страна с таким названием уже существует!");
        }
    }


    /**
     * Создание элементов типов производителей
     */
    public GeneralCatalogDTO addManufacturer(String name) {

        if (!manufacturerRepository.existsByName(name)) {

            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setDeleted(false);
            manufacturer.setName(name);
            manufacturerRepository.save(manufacturer);

            return catalogMapper.catalogToCatalogsDTO(manufacturer);
        } else {
            throw new BadRequestException("Ошибка! Производитель с таким названием уже существует!");
        }
    }


    /**
     * Создание элементов типов пакетов
     */
    public GeneralCatalogDTO addPackaging(String name) {

        if (!packagingRepository.existsByName(name)) {

            Packaging packaging = new Packaging();
            packaging.setDeleted(false);
            packaging.setName(name);
            packagingRepository.save(packaging);

            return catalogMapper.catalogToCatalogsDTO(packaging);

        } else {
            throw new BadRequestException("Ошибка! Упаковка с таким названием уже существует!");
        }
    }


    /**
     * Создание элементов типов обжарки
     */
    public GeneralCatalogDTO addRoasting(String name) {

        if (!roastingRepository.existsByName(name)) {

            Roasting roasting = new Roasting();
            roasting.setDeleted(false);
            roasting.setName(name);
            roastingRepository.save(roasting);

            return catalogMapper.catalogToCatalogsDTO(roasting);

        } else {
            throw new BadRequestException("Ошибка! Прожарка с таким названием уже существует!");
        }
    }


    /**
     * Создание элементов цветов чая
     */
    public GeneralCatalogDTO addTeaColor(String name) {

        if (!teaColorRepository.existsByName(name)) {

            TeaColor teaColor = new TeaColor();
            teaColor.setDeleted(false);
            teaColor.setName(name);
            teaColorRepository.save(teaColor);

            return catalogMapper.catalogToCatalogsDTO(teaColor);

        } else {
            throw new BadRequestException("Ошибка! Цвет чая с таким названием уже существует!");
        }
    }

    /**
     * Создание элементов типов чая
     */
    public GeneralCatalogDTO addTeaType(String name) {

        if (!teaTypeRepository.existsByName(name)) {

            TeaType teaType = new TeaType();
            teaType.setDeleted(false);
            teaType.setName(name);
            teaTypeRepository.save(teaType);

            return catalogMapper.catalogToCatalogsDTO(teaType);

        } else {
            throw new BadRequestException("Ошибка! Тип чая с таким названием уже существует!");
        }
    }


    /**
     * Удаление элементов типов кофе
     */
    public void deleteCoffeeType(Long coffeeTypeId) {

        CoffeeType coffeeType = coffeeTypeRepository
                .findById(coffeeTypeId)
                .orElseThrow(() -> new EntityNotFoundException(coffeeTypeId));

        coffeeType.setDeleted(true);
        coffeeTypeRepository.save(coffeeType);

    }

    /**
     * Удаление элементов стран
     */
    public void deleteCountry(Long countryId) {

        Country country = countriesRepository
                .findById(countryId)
                .orElseThrow(() -> new EntityNotFoundException(countryId));
        country.setDeleted(true);
        countriesRepository.save(country);
    }

    /**
     * Удаление элементов произваодителей
     */
    public void deleteManufacturer(Long manufacturerId) {

        Manufacturer manufacturer = manufacturerRepository
                .findById(manufacturerId)
                .orElseThrow(() -> new EntityNotFoundException(manufacturerId));
        manufacturer.setDeleted(true);
        manufacturerRepository.save(manufacturer);
    }

    /**
     * Удаление элементов упаковок
     */
    public void deletePackaging(Long packagingId) {

        Packaging packaging = packagingRepository
                .findById(packagingId)
                .orElseThrow(() -> new EntityNotFoundException(packagingId));
        packaging.setDeleted(true);
        packagingRepository.save(packaging);
    }

    /**
     * Удаление элементов обжарки кофе
     */
    public void deleteRoasting(Long roastingId) {

        Roasting roasting = roastingRepository
                .findById(roastingId)
                .orElseThrow(() -> new EntityNotFoundException(roastingId));
        roasting.setDeleted(true);
        roastingRepository.save(roasting);
    }

    /**
     * Удаление элементов цвета чая
     */
    public void deleteTeaColor(Long teaColorId) {

        TeaColor teaColor = teaColorRepository
                .findById(teaColorId)
                .orElseThrow(() -> new EntityNotFoundException(teaColorId));
        teaColor.setDeleted(true);
        teaColorRepository.save(teaColor);
    }

    /**
     * Удаление элементов типа чая
     */
    public void deleteTeaType(Long teaTypeId) {

        TeaType teaType = teaTypeRepository
                .findById(teaTypeId)
                .orElseThrow(() -> new EntityNotFoundException(teaTypeId));
        teaType.setDeleted(true);
        teaTypeRepository.save(teaType);
    }

    /**
     * Получение списка стран
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findCountries() {

        return catalogMapper.catalogsToCatalogsDTO(countriesRepository.findAllByDeletedIsFalse(Sort.by("name").ascending()));
    }

    /**
     * Получение списка производителей
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findManufacturers() {

        return catalogMapper.catalogsToCatalogsDTO(manufacturerRepository.findAllByDeletedIsFalse(Sort.by("name").ascending()));
    }

    /**
     * Получение списка обжарки
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findRoastings() {

        return catalogMapper.catalogsToCatalogsDTO(roastingRepository.findAllByDeletedIsFalse(Sort.by("name").ascending()));
    }

    /**
     * Получение списка упаковок
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findPackages() {

        return catalogMapper.catalogsToCatalogsDTO(packagingRepository.findAllByDeletedIsFalse(Sort.by("name").ascending()));
    }

    /**
     * Получение списка цвета чая
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findTeaColors() {

        return catalogMapper.catalogsToCatalogsDTO(teaColorRepository.findAllByDeletedIsFalse(Sort.by("name").ascending()));
    }

    /**
     * Получение списка типов кофе
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findCoffeeTypes() {

        return catalogMapper.catalogsToCatalogsDTO(coffeeTypeRepository.findAllByDeletedIsFalse(Sort.by("name").ascending()));
    }

    /**
     * Получение списка типов чая
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findTeaTypes() {

        return catalogMapper.catalogsToCatalogsDTO(teaTypeRepository.findAllByDeletedIsFalse(Sort.by("name").ascending()));
    }
}