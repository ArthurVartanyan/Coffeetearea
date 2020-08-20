package ru.coffeetearea.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.coffeetearea.model.catalog.Country;
import ru.coffeetearea.model.catalog.Manufacturer;
import ru.coffeetearea.model.catalog.Packaging;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


@Data
@Entity
@NoArgsConstructor
@Table(name = "drink")
@Inheritance(strategy = InheritanceType.JOINED)
public class Drink {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * Название напитка
     */
    private String name;

    /**
     * Цена напитка
     */
    private BigDecimal price;

    /**
     * Описание напитка
     */
    private String about;


    /**
     * Вес вещества(например: 100гр. или 1 кг.)
     */
    private int weight;

    /**
     * Флаг удаления
     */
    @Column(name = "is_deleted")
    private boolean isDeleted;

    /**
     * Упаковка напитка
     */
    @ManyToOne
    @JoinColumn(name = "packaging_id")
    private Packaging packaging;

    /**
     * Производитель
     */
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    /**
     * Страна производитель
     */
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return isDeleted == drink.isDeleted &&
                Objects.equals(id, drink.id) &&
                Objects.equals(name, drink.name) &&
                Objects.equals(price, drink.price) &&
                Objects.equals(about, drink.about) &&
                Objects.equals(packaging, drink.packaging) &&
                Objects.equals(manufacturer, drink.manufacturer) &&
                Objects.equals(country, drink.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, about, isDeleted, packaging, manufacturer, country);
    }
}