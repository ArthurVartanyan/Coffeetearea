package ru.coffeetearea.model;

import ru.coffeetearea.model.directory.TeaColor;
import ru.coffeetearea.model.directory.TeaType;

import javax.persistence.*;

@Entity
@Table(name = "tea", schema = "public")
public class Tea {

    public Tea() { // Constructor for Hibernate

    }


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