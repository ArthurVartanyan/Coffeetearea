package ru.coffeetearea.DTO;

import ru.coffeetearea.model.directory.Countries;
import ru.coffeetearea.model.directory.Manufacturer;
import ru.coffeetearea.model.directory.Packaging;

public class DrinkDTO {

    // Fields
    //
    private String drinkName;

    private float drinkPrice;

    private String drinkAbout;

    private Packaging drinkPackaging;

    private Manufacturer drinkManufacturer;

    private Countries drinkCountries;


    // Getters and Setters
    //
    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public float getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(float drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public String getDrinkAbout() {
        return drinkAbout;
    }

    public void setDrinkAbout(String drinkAbout) {
        this.drinkAbout = drinkAbout;
    }

    public Packaging getDrinkPackaging() {
        return drinkPackaging;
    }

    public void setDrinkPackaging(Packaging drinkPackaging) {
        this.drinkPackaging = drinkPackaging;
    }

    public Manufacturer getDrinkManufacturer() {
        return drinkManufacturer;
    }

    public void setDrinkManufacturer(Manufacturer drinkManufacturer) {
        this.drinkManufacturer = drinkManufacturer;
    }

    public Countries getDrinkCountries() {
        return drinkCountries;
    }

    public void setDrinkCountries(Countries drinkCountries) {
        this.drinkCountries = drinkCountries;
    }

    // toSTRING
    @Override
    public String toString() {
        return "DrinkDTO{" +
                "drinkName='" + drinkName + '\'' +
                ", drinkPrice=" + drinkPrice +
                ", drinkAbout='" + drinkAbout + '\'' +
                ", drinkPackaging=" + drinkPackaging +
                ", drinkManufacturer=" + drinkManufacturer +
                ", drinkCountries=" + drinkCountries +
                '}';
    }
}