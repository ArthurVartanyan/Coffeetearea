package ru.coffeetearea.model;

import lombok.Data;
import ru.coffeetearea.model.catalog.Countries;
import ru.coffeetearea.model.catalog.Manufacturer;
import ru.coffeetearea.model.catalog.Packaging;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Класс: Напиток
 * Содержит поля: id(ИД), name(название), price(цена), about(описание), is_deleted(флаг(удален, не удален)).
 * Через связи есть поля packaging(тип упаковки), manufacturer(производитель), countries(страна).
 */

@Data
@Entity
@Table(name = "drink")
@Inheritance(strategy = InheritanceType.JOINED)
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "cart_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "drink_id"))
    private List<Order> order;
}