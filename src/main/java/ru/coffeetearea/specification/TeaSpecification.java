package ru.coffeetearea.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.coffeetearea.model.Tea;
import ru.coffeetearea.model.Tea_;
import ru.coffeetearea.model.catalog.Countries_;
import ru.coffeetearea.model.catalog.TeaColor_;
import ru.coffeetearea.model.catalog.TeaType_;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class TeaSpecification {

    public static Specification<Tea> getTeasByFilter(Long colorId, Long typeId, Long countryId) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicateList = new ArrayList<>();

            if (colorId != null) {
                Predicate colorPredicate = criteriaBuilder
                        .equal(root.get(Tea_.teaColor).get(TeaColor_.id), colorId);
                predicateList.add(colorPredicate);
            }
            if (typeId != null) {
                Predicate typePredicate = criteriaBuilder
                        .equal(root.get(Tea_.teaType).get(TeaType_.id), typeId);
                predicateList.add(typePredicate);
            }
            if (countryId != null) {
                Predicate countryPredicate = criteriaBuilder
                        .equal(root.get(Tea_.countries).get(Countries_.id), countryId);
                predicateList.add(countryPredicate);
            }

            Predicate predicates = criteriaBuilder.and(predicateList.toArray(new Predicate[0]));

            return criteriaBuilder.and(predicates);
        };
    }
}