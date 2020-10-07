package ru.coffeetearea.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.coffeetearea.model.*;
import ru.coffeetearea.model.catalog.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DrinksSpecification {

    /**
     * В этот метод вынесены общие параметры
     *
     * @param countryId
     * @param min
     * @param max
     * @param root
     * @param cb
     * @return List of predicates
     */
    private static List<Predicate> getDrinkPredicates(String drinkName, Long countryId, BigDecimal min, BigDecimal max,
                                                      Root<? extends Drink> root, CriteriaBuilder cb) {

        List<Predicate> predicateList = new ArrayList<>();

        // Страна
        if (countryId != null) {
            Predicate countryPredicate = cb
                    .equal(root.get(Drink_.country).get(Country_.id), countryId);
            predicateList.add(countryPredicate);
        }
        // Название
        if (drinkName != null) {
            Predicate namePredicate = cb
                    .equal(root.get(Drink_.name), drinkName);
            predicateList.add(namePredicate);
        }
        // Если И мин И мах НЕ равны нулю
        if (min != null && max != null) {
            Predicate pricePredicate = cb.between(root.get(Drink_.price), min, max);
            predicateList.add(pricePredicate);
        }
        // Если хоть ОДИН из них РАВЕН нулю
        if (min != null || max != null) {
            // Если МАКС РАВЕН
            if (min != null) {
                Predicate pricePredicate = cb.ge(root.get(Drink_.price), min);
                predicateList.add(pricePredicate);
            }
            // Если МИН РАВЕН
            if (max != null) {
                Predicate pricePredicate = cb.le(root.get(Drink_.price), max);
                predicateList.add(pricePredicate);
            }
        }
        return predicateList;
    }


    /**
     * Метод для ЧАЯ
     *
     * @param colorId
     * @param typeId
     * @param countryId
     * @param min
     * @param max
     * @return List of predicates
     */
    public static Specification<Tea> getTeasByFilter(String drinkName, Long colorId, Long typeId, Long countryId,
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

            Predicate isDeletedPredicate = criteriaBuilder
                    .equal(root.get(Tea_.deleted), false);
            predicateList.add(isDeletedPredicate);

            predicateList.addAll(getDrinkPredicates(drinkName, countryId,
                    min, max, root, criteriaBuilder));

            Predicate predicates = criteriaBuilder.and(predicateList.toArray(new Predicate[0]));

            return criteriaBuilder.and(predicates);
        };
    }


    /**
     * Метод для КОФЕ
     *
     * @param roastingId
     * @param typeId
     * @param countryId
     * @param min
     * @param max
     * @return List of predicates
     */
    public static Specification<Coffee> getCoffeesByFilter(String drinkName, Long roastingId, Long typeId, Long countryId,
                                                           BigDecimal min, BigDecimal max) {

        return (root, query, criteriaBuilder) -> {
            // Создаю лист, чтобы заполнять его Предикатами(см. по параметрам)
            List<Predicate> predicateList = new ArrayList<>();
            // Условные операторы для того, чтобы откидывать параметры, если они null
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
            Predicate isDeletedPredicate = criteriaBuilder
                    .equal(root.get(Coffee_.deleted), false);
            predicateList.add(isDeletedPredicate);

            predicateList.addAll(getDrinkPredicates(drinkName, countryId,
                    min, max, root, criteriaBuilder));

            Predicate predicates = criteriaBuilder.and(predicateList.toArray(new Predicate[0]));

            return criteriaBuilder.and(predicates);
        };
    }
}