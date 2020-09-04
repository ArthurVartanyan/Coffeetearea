package ru.coffeetearea.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.coffeetearea.model.Role;
import ru.coffeetearea.security.JwtUserDetailsService;
import ru.coffeetearea.security.jwt.JwtConfigurer;
import ru.coffeetearea.security.jwt.JwtTokenProvider;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Fields

    private final JwtUserDetailsService jwtUserDetailsService;


    /**
     * Использован BCrypt
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

    /**
     * Работаем без внедрения зависимостей, так как возникает цикличность
     *
     * @param userDetailsService
     * @return JwtTokenProvider
     */
    @Bean
    public JwtTokenProvider jwtTokenProvider(JwtUserDetailsService userDetailsService) {
        return new JwtTokenProvider(userDetailsService);
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    /**
     * Метод конфигураций.
     * Вместо аннотаций над методами и классами для доступа по ролям,
     * было решено использовать antMatchers с ограничениями по ссылкам (по ролям).
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
                .antMatchers("/catalogs/countries")
                .hasAuthority(Role.CUSTOMER.name())
                .antMatchers("/home/login", "/home/registration", "/drinks/image", "/cart-item/list", "/cart-item/**",
                        "/cart-item/all", "/coffee", "/coffee/**", "/**/delete", "/all", "/filter", "/tea", "/tea/**",
                        "/**/delete", "/all", "/filter", "/orders", "/users", "/drinks/drinks/**/favourites",
                        "/drinks/favourites", "/drinks/populars", "/**/favourites", "/catalogs/coffee-types",
                        "/catalogs/manufacturers", "/catalogs/packages", "/catalogs/roastings",
                        "/catalogs/tea-colors", "/catalogs/tea-types", "/catalogs/**/coffee-types",
                        "/catalogs/**/countries", "/catalogs/**/manufacturers",
                        "/catalogs/**/packages", "/catalogs/**/roastings",
                        "/catalogs/**/tea-colors", "/catalogs/**/tea-types", "/catalogs/**/delete/coffee-type",
                        "/catalogs/**/delete/country", "/catalogs/**/delete/manufacturer",
                        "/catalogs/**/delete/package", "/catalogs/**/delete/roasting",
                        "/catalogs/**/delete/tea-color", "/catalogs/**/delete/tea-type").permitAll()// Все ссылки, которые доступны только заказчику
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider(jwtUserDetailsService)));
    }
}