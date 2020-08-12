package ru.coffeetearea.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageDTO<T> {

    /**
     * Конструктор
     *
     * @param page
     */
    public PageDTO(Page<T> page) {
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.number = page.getNumber();
        this.size = page.getSize();
        this.content = page.getContent();
    }

    /**
     * Количество элементов
     */
    private Long totalElements;

    /**
     * Количество страниц
     */
    private int totalPages;

    /**
     * Номер страницы
     */
    private int number;

    /**
     * Размер страницы (отображение)
     */
    private int size;

    /**
     * Список содержимого
     */
    private List<T> content;
}