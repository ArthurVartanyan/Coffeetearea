package ru.coffeetearea.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.coffeetearea.security.JwtUserDetailsService;
import ru.coffeetearea.security.jwt.JwtConfigurer;
import ru.coffeetearea.security.jwt.JwtTokenProvider;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true) // Включаем @RolesAllowed
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
                // Раздаем статику
                .antMatchers("/static/**").permitAll()
                // Раздаем Swagger
                .antMatchers("/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**").permitAll()
                // Раздаем странички и ссылки, которые доступны всем
                        // Ссылки
                .antMatchers("/api/users/login",  "/api/users/info", "/api/users/registration", "/api/coffee/all", "/api/coffee/filter",
                        "/api/drinks/populars", "/api/drinks/**/image", "/api/tea/all", "/api/tea/filter", "/api/catalogs/roastings", "/api/catalogs/coffee-types",
                        "/api/catalogs/tea-types", "/api/catalogs/tea-colors", "/api/catalogs/countries", "/api/coffee/**", "/api/tea/**",
                        // Страницы
                        "/login", "/errorLogin", "/contacts", "/coffees", "/teas", "/home", "/about", "/registration",
                        "/card", "/order", "/drink-coffee", "/favourites", "/admin", "/admin-roastings", "/admin-manufacturers",
                        "/admin-countries", "/admin-coffee-type", "/admin-tea-types", "/admin-tea-colors", "/admin-packages", "/admin-catalog",
                        "/admin-coffee", "/admin-tea", "/admin-order")
                .permitAll()
                .anyRequest()
                .authenticated().and()
                .logout()
                .permitAll()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider(jwtUserDetailsService)));
    }
}