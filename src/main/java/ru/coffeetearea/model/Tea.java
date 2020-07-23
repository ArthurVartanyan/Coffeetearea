package ru.coffeetearea.model;

import ru.coffeetearea.model.catalog.TeaColor;
import ru.coffeetearea.model.catalog.TeaType;

import javax.persistence.*;

@Entity
@Table(name = "tea")
public class Tea {

    // Fields
    //
    private @Id
    @GeneratedValue
    Long id;

    // Relationships
    //
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "drink_id")
    private Drink drink;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TeaType teaType;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private TeaColor teaColor;
}