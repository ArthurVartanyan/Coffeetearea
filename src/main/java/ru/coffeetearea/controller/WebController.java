package ru.coffeetearea.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WebController {

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/coffees")
    public String coffeesPage() {
        return "coffees";
    }

    @GetMapping("/test")
    public String testsPage() {
        return "test";
    }

    @GetMapping("/contacts")
    public String contactsPage() {
        return "contacts";
    }

    @GetMapping("/teas")
    public String teasPage() {
        return "teas";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/registration")
    public String registrationPage() {
        return "registration";
    }

    @GetMapping("/card")
    public String cardPage() {
        return "card";
    }

    @GetMapping("/order")
    public String orderPage() {
        return "order";
    }

    @GetMapping("/errorLogin")
    public String errorLoginPage() {
        return "errorLogin";
    }

    @GetMapping("/drink-coffee")
    public String drinkCoffeePage() {
        return "drinkCoffee";
    }

    @GetMapping("/favourites")
    public String favouritesPage() {
        return "favourites";
    }

    @GetMapping("/admin-catalog")
    public String adminsPage() {
        return "adminCatalog";
    }

    @GetMapping("/admin-coffee-type")
    public String adminCoffeeTypesPage() {
        return "adminCoffeeType";
    }

    @GetMapping("/admin-countries")
    public String adminsCountriesPage() {
        return "adminCountries";
    }

    @GetMapping("/admin-manufacturers")
    public String adminsManufacturersPage() {
        return "adminManufacturers";
    }

    @GetMapping("/admin-roastings")
    public String adminsRoastingsPage() {
        return "adminRoastings";
    }

    @GetMapping("/admin-tea-types")
    public String adminsTeaTypesPage() {
        return "adminTeaTypes";
    }

    @GetMapping("/admin-tea-colors")
    public String adminsTeaColorsPage() {
        return "adminTeaColors";
    }

    @GetMapping("/admin-packages")
    public String adminsPackagesPage() {
        return "adminPackages";
    }

    @GetMapping("/admin-coffee")
    public String adminsCoffeePage() {
        return "adminCoffee";
    }

    @GetMapping("/admin-tea")
    public String adminsTeaPage() {
        return "adminTea";
    }
}