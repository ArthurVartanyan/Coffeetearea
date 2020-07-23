package ru.coffeetearea.model;

import lombok.Data;
import ru.coffeetearea.model.catalog.Countries;
import ru.coffeetearea.model.catalog.Manufacturer;
import ru.coffeetearea.model.catalog.Packaging;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "drink")
public class Drink {

    // Fields
    //
    private @Id
    @GeneratedValue
    Long id;

    private String name;

    private BigDecimal price;

    private String about;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    // Relationships
    //
    @ManyToOne
    @JoinColumn(name = "packaging_id")
    private Packaging packaging;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Countries countries;
}