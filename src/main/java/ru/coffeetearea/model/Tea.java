package ru.coffeetearea.model;

import lombok.Setter;
import ru.coffeetearea.model.catalog.TeaColor;
import ru.coffeetearea.model.catalog.TeaType;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Setter
@Entity
@Table(name = "tea")
public class Tea extends Drink {

    /**
     * Тип чая
     */
    @ManyToOne
    @JoinColumn(name = "type_id")
    private TeaType teaType;

    /**
     * Цвет чая
     */
    @ManyToOne
    @JoinColumn(name = "color_id")
    private TeaColor teaColor;
}