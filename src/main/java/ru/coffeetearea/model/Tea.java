package ru.coffeetearea.model;

import ru.coffeetearea.model.catalog.TeaColor;
import ru.coffeetearea.model.catalog.TeaType;

import javax.persistence.*;

@Entity
@Table(name = "tea")
public class Tea extends Drink {

    // Relationships
    //
    /* Тип чая */
    @ManyToOne
    @JoinColumn(name = "type_id")
    private TeaType teaType;

    /* Цвет чая */
    @ManyToOne
    @JoinColumn(name = "color_id")
    private TeaColor teaColor;
}