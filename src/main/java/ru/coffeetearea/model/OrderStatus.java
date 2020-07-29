package ru.coffeetearea.model;

/**
 * Статусы заказов: Новый(не оплачен или неактивен) Активный(в процессе),
 * Canceled(отменен), Completed(завершен успешно).
 */

public enum OrderStatus {

    NEW, ACTIVE, CANCELED, COMPLETED
}