package ru.coffeetearea.model;

import ru.coffeetearea.model.catalog.TeaColor;
import ru.coffeetearea.model.catalog.TeaType;

import javax.persistence.*;

/**
 * Класс: Чай
 * Содержит поля: id(ИД), teaType(тип чая(листовой...)), teaColor(цвет чая).
 * Через наследование связан с классом Drink(Напиток).
 */

@Entity
@Table(name = "tea")
public class Tea extends Drink {

    // Relationships
    //
    @ManyToOne
    @JoinColumn(name = "type_id")
    private TeaType teaType;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private TeaColor teaColor;
}