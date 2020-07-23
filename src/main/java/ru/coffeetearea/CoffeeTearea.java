package ru.coffeetearea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.coffeetearea.model.catalog.Manufacturer;

@SpringBootApplication
public class CoffeeTearea {
    public static void main(String[] args) {

        SpringApplication.run(CoffeeTearea.class, args);
    }
}