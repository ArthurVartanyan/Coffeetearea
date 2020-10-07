package ru.coffeetearea.dto;

/**
 * ENUM для сортировки товара на странице.
 * INCREASE & DECREASE - возрастание и убывание, соответственно:
 * цена,
 * популярность,
 * название.
 */

public enum SortingParams {

    PRICE_INCREASE, PRICE_DECREASE, POP_DECREASE, NAME_INCREASE
}