package ru.coffeetearea.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
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
     * Количество напитка в корзине
     */
    @Formula("coalesce((select sum(c.count) from cart_items c" +
            " left join pg_order po on c.order_id = po.id" +
            " where po.order_status = 'ACTIVE' and " +
            "c.drink_id = id), 0)")
//    @Formula("coalesce((select sum(c.count) from cart_items c where c.drink_id = id), 0)")
    private Long drinkCountInOrder;

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