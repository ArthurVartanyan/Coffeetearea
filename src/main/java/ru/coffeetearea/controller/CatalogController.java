package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffeetearea.model.catalog.Countries;
import ru.coffeetearea.service.CatalogService;

@Api(value = "Catalog", tags = {"catalog"})
@RestController
@RequestMapping("/catalog")
public class CatalogController<T> {

}