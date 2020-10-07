package ru.coffeetearea.model;

/**
 * Это Enum нужен нам для перечисления статусов заказа.
 * Статусы заказов:
 * Новый(не оплачен или неактивен),
 * Активный(в процессе),
 * Canceled(отменен),
 * Completed(завершен успешно).
 */

public enum OrderStatus {

    NEW, ACTIVE, CANCELED, COMPLETED
}