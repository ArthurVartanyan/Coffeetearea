package ru.coffeetearea.dto;

/**
 * ENUM для сортировки товара на странице.
 * INCREASE & DECREASE - возрастание и убывание, соответственно по цене, популярности и названию.
 */

public enum SortingParams {

    PRICE_INCREASE, PRICE_DECREASE, NAME_INCREASE, POP_DECREASE
}