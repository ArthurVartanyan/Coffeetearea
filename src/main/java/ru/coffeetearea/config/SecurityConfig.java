package ru.coffeetearea.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import ru.coffeetearea.model.Role;
import ru.coffeetearea.security.jwt.JwtConfigurer;
import ru.coffeetearea.security.jwt.JwtTokenProvider;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Fields
    //
    private final JwtTokenProvider jwtTokenProvider;


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    /**
     * Метод конфигураций.
     * Вместо аннотаций над методами и классами для доступа по ролям,
     * было решено использовать antMatchers с ограничениями по ссылкам(по ролям).
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable().csrf().disable()
                .httpBasic().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**").permitAll()
                .antMatchers("/home/login",
                        "/cart-item", "/cart-drinks",
                        "/**/add-cart/", "/**/delete-cart/", "/delete-all-cart",
                        "/add-in-favourites/**", "/coffee", "/coffees", "/coffees-filter",
                        "/tea", "/teas", "/teas-filter", "/drink","/**/favourite-delete",
                        "/**/add-favourites/", "/drinks-favourite", "/order", "/make-order").permitAll()
                .antMatchers()
                .hasRole(Role.CUSTOMER.name()) // Все ссылки, которые доступны только заказчику
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}