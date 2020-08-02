package ru.coffeetearea.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.coffeetearea.model.Coffee;
import ru.coffeetearea.model.Coffee_;
import ru.coffeetearea.model.catalog.CoffeeType_;
import ru.coffeetearea.model.catalog.Countries_;
import ru.coffeetearea.model.catalog.Roasting_;

import javax.persistence.criteria.Predicate;

public class CoffeeSpecification {

    public static Specification<Coffee> getCoffeesByFilter(Long roastingId, Long typeId, Long countryId) {
        return (root, query, criteriaBuilder) -> {
            Predicate roastingPredicate = criteriaBuilder
                    .equal(root.get(Coffee_.roasting).get(Roasting_.id), roastingId);
            Predicate typePredicate = criteriaBuilder
                    .equal(root.get(Coffee_.coffeeType).get(CoffeeType_.id), typeId);
            Predicate countryPredicate = criteriaBuilder
                    .equal(root.get(Coffee_.countries).get(Countries_.id), countryId);
            return criteriaBuilder.and(roastingPredicate, typePredicate, countryPredicate);
        };
    }
}