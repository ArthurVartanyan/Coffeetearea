package ru.coffeetearea.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.coffeetearea.model.Coffee;
import ru.coffeetearea.model.Coffee_;
import ru.coffeetearea.model.catalog.CoffeeType_;
import ru.coffeetearea.model.catalog.Countries_;
import ru.coffeetearea.model.catalog.Roasting_;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class CoffeeSpecification {

    public static Specification<Coffee> getCoffeesByFilter(Long roastingId, Long typeId, Long countryId) {

        List<Predicate> predicateList = new ArrayList<>();

        return (root, query, criteriaBuilder) -> {
            if (roastingId != null) {
                Predicate roastingPredicate = criteriaBuilder
                        .equal(root.get(Coffee_.roasting).get(Roasting_.id), roastingId);
                predicateList.add(roastingPredicate);
            }
            if (typeId != null) {
                Predicate typePredicate = criteriaBuilder
                        .equal(root.get(Coffee_.coffeeType).get(CoffeeType_.id), typeId);
                predicateList.add(typePredicate);
            }
            if (countryId != null) {
                Predicate countryPredicate = criteriaBuilder
                        .equal(root.get(Coffee_.countries).get(Countries_.id), countryId);
                predicateList.add(countryPredicate);
            }
            Predicate predicates = criteriaBuilder.and(predicateList.toArray(new Predicate[0]));

            return criteriaBuilder.and(predicates);
        };
    }
}