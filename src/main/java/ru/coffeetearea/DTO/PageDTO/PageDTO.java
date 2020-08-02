package ru.coffeetearea.DTO.PageDTO;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageDTO<T> {

    public PageDTO(Page<T> page) {
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.number = page.getNumber();
        this.size = page.getSize();
        this.content = page.getContent();
    }

    private Long totalElements;

    private int totalPages;

    private int number;

    private int size;

    private List<T> content;
}