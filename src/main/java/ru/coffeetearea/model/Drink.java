package ru.coffeetearea.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.coffeetearea.model.catalog.Countries;
import ru.coffeetearea.model.catalog.Manufacturer;
import ru.coffeetearea.model.catalog.Packaging;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
@NoArgsConstructor
@Table(name = "drink")
@Inheritance(strategy = InheritanceType.JOINED)
public class Drink {

    // Fields
    //
    @Id
    @GeneratedValue
    private Long id;

    /** Название напитка */
    private String name;

    /** Цена напитка */
    private BigDecimal price;

    /** Описание напитка */
    private String about;

    /** Флаг удаления */
    @Column(name = "is_deleted")
    private boolean isDeleted;

    // Relationships
    //
    /** Упаковка напитка */
    @ManyToOne
    @JoinColumn(name = "packaging_id")
    private Packaging packaging;

    /** Производитель */
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    /** Страна производитель */
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Countries countries;
}