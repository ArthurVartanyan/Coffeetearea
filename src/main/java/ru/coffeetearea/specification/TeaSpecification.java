package ru.coffeetearea.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.coffeetearea.model.Tea;
import ru.coffeetearea.model.Tea_;
import ru.coffeetearea.model.catalog.Countries_;
import ru.coffeetearea.model.catalog.TeaColor_;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;

public class TeaSpecification {

    public static Specification<Tea> getTeasByFilter(String color, String type, String country) {
        return (root, query, criteriaBuilder) -> {
            Join<Object, Object> colorJoin = root.join(Tea_.TEA_COLOR);
            Join<Object, Object> countryJoin = root.join(Tea_.COUNTRIES);
            Join<Object, Object> typeJoin = root.join(Tea_.TEA_TYPE);
            Predicate colorPredicate = criteriaBuilder.equal(colorJoin.get(TeaColor_.NAME), color);
            Predicate countryPredicate = criteriaBuilder.equal(countryJoin.get(Countries_.NAME), country);
            Predicate typePredicate = criteriaBuilder.equal(typeJoin.get(TeaColor_.NAME), type);
            return criteriaBuilder.and(colorPredicate, typePredicate, countryPredicate);
        };
    }
}