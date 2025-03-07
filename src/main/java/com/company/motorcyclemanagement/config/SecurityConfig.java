package com.company.motorcyclemanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("api/accidents/**").permitAll() // Allow access
                        .requestMatchers("api/bike-employee/**").permitAll() // Allow access
                        .requestMatchers("api/branches/**").permitAll() // Allow access
                        .requestMatchers("api/insurance/**").permitAll() // Allow access
                        .requestMatchers("api/license/**").permitAll() // Allow access
                        .requestMatchers("api/maintenance/**").permitAll() // Allow access
                        .requestMatchers("api/motorcycle-allowance/**").permitAll() // Allow access
                        .requestMatchers("/api/motorcycles/**").permitAll() // Allow access
                        .requestMatchers("api/other-employee/**").permitAll() // Allow access
                        .requestMatchers("api/running-chart/**").permitAll() // Allow access
                        .requestMatchers("/api/statuses/**").permitAll() // Allow access
                        .requestMatchers("/api/roles/**").permitAll() // Allow access
                        .requestMatchers("/api/auth/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin().disable()
                .httpBasic();
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
