package ru.coffeetearea.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.coffeetearea.model.Coffee;
import ru.coffeetearea.model.Coffee_;
import ru.coffeetearea.model.catalog.CoffeeType_;
import ru.coffeetearea.model.catalog.Countries_;
import ru.coffeetearea.model.catalog.Roasting_;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;

public class CoffeeSpecification {

    public static Specification<Coffee> getCoffeesByFilter(String roasting, String type, String country) {
        return (root, query, criteriaBuilder) -> {
            Join<Object, Object> roastingJoin = root.join(Coffee_.ROASTING);
            Join<Object, Object> countryJoin = root.join(Coffee_.COUNTRIES);
            Join<Object, Object> typeJoin = root.join(Coffee_.COFFEE_TYPE);
            Predicate roastingPredicate = criteriaBuilder.equal(roastingJoin.get(Roasting_.NAME), roasting);
            Predicate countryPredicate = criteriaBuilder.equal(countryJoin.get(Countries_.NAME), country);
            Predicate typePredicate = criteriaBuilder.equal(typeJoin.get(CoffeeType_.NAME), type);
            return criteriaBuilder.and(roastingPredicate, typePredicate, countryPredicate);
        };
    }
}