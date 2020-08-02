package ru.coffeetearea.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.coffeetearea.model.Tea;
import ru.coffeetearea.model.Tea_;
import ru.coffeetearea.model.catalog.Countries_;
import ru.coffeetearea.model.catalog.TeaColor_;
import ru.coffeetearea.model.catalog.TeaType_;

import javax.persistence.criteria.Predicate;

public class TeaSpecification {

    public static Specification<Tea> getTeasByFilter(Long colorId, Long typeId, Long countryId) {
        return (root, query, criteriaBuilder) -> {
            Predicate colorPredicate = criteriaBuilder
                    .equal(root.get(Tea_.teaColor).get(TeaColor_.id), colorId);
            Predicate typePredicate = criteriaBuilder
                    .equal(root.get(Tea_.teaType).get(TeaType_.id), typeId);
            Predicate countryPredicate = criteriaBuilder
                    .equal(root.get(Tea_.countries).get(Countries_.id), countryId);
            return criteriaBuilder.and(colorPredicate, typePredicate, countryPredicate);
        };
    }
}