package ru.coffeetearea.DTO.PageDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageDTO<T> {

    @Data
    @AllArgsConstructor
    static class CustomPage {

        private Long totalElements;

        private int totalPages;

        private int number;

        private int size;
    }


    private List<T> content;

    private CustomPage customPage;

    public PageDTO(Page<T> page) {
        this.content = page.getContent();
        this.customPage = new CustomPage(page.getTotalElements(),
                page.getTotalPages(), page.getNumber(), page.getSize());
    }
}