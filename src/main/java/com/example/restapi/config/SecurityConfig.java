
package com.example.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Вимкнення CSRF захисту, використовуйте з обережністю
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/login").permitAll()  // Дозвіл доступу до login без авторизації
                        .anyRequest().authenticated()  // Інші запити повинні бути авторизовані
                )
                .httpBasic(); // Використовуємо httpBasic замість formLogin

        return http.build();
    }
}
