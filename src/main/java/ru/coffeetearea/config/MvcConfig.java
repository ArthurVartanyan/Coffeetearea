package ru.coffeetearea.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * Делаем видимым наши страницы
     *
     * @param registry
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/coffees").setViewName("coffees");
        registry.addViewController("/teas").setViewName("teas");
        registry.addViewController("/contacts").setViewName("contacts");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/card").setViewName("card");
        registry.addViewController("/order").setViewName("order");
        registry.addViewController("/errorLogin").setViewName("errorLogin");
        registry.addViewController("/drink").setViewName("drink");
        registry.addViewController("/admin").setViewName("admCatalog");
        registry.addViewController("/favourites").setViewName("favourites");
    }


    /**
     * Данный метод помогает Spring обнаруживать пути к файлам
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/");
    }
}