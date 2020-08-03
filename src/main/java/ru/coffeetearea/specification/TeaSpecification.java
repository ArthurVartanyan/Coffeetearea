package ru.coffeetearea.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.coffeetearea.model.Tea;
import ru.coffeetearea.model.Tea_;
import ru.coffeetearea.model.catalog.Countries_;
import ru.coffeetearea.model.catalog.TeaColor_;
import ru.coffeetearea.model.catalog.TeaType_;

import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TeaSpecification {

    public static Specification<Tea> getTeasByFilter(Long colorId, Long typeId, Long countryId,
                                                     BigDecimal min, BigDecimal max) {
        return (root, query, criteriaBuilder) -> {
            // Создаю лист, чтобы заполнять его Предикатами(см. по параметрам)
            List<Predicate> predicateList = new ArrayList<>();
            // Условные операторы для того, чтобы откидывать параметры, если они null
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
            if (min != null || max != null) {
                Predicate pricePredicate = criteriaBuilder.between(root.get(Tea_.price), min, max);
                predicateList.add(pricePredicate);
            }
            Predicate predicates = criteriaBuilder.and(predicateList.toArray(new Predicate[0]));

            return criteriaBuilder.and(predicates);
        };
    }
}