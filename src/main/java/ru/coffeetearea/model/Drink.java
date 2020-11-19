package ru.coffeetearea.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Formula;
import ru.coffeetearea.model.catalog.Country;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Изображение товара(напитка)
     */
    @Column(name = "image")
    private String image;

    /**
     * Название напитка
     */
    @Column(name = "name")
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
    private Long drinkCountInOrder;

    /**
     * Описание напитка
     */
    @Column(name = "about")
    private String about;

    /**
     * Вес вещества(отображается в граммах, но хранится в килограммах)
     */
    @Column(name = "weight")
    @ColumnTransformer(read = "weight * 1000",
                       write = "? / 1000") // Вес в БД храним в кг.
    private double weight;

    /**
     * Флаг удаления
     */
    @Column(name = "is_deleted")
    private boolean deleted;

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
}