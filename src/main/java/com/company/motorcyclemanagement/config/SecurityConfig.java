package com.company.motorcyclemanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf(csrf -> csrf.disable()) // Explicitly disable CSRF
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/accidents/**").permitAll() // Allow access
                        .requestMatchers("/api/bike-employee/**").permitAll() // Allow access
                        .requestMatchers("/api/branches/**").permitAll() // Allow access
                        .requestMatchers("/api/insurance/**").permitAll() // Allow access
                        .requestMatchers("/api/license/**").permitAll() // Allow access
                        .requestMatchers("/api/maintenance/**").permitAll() // Allow access
                        .requestMatchers("/api/motorcycle-allowance/**").permitAll() // Allow access
                        .requestMatchers("/api/motorcycles/**").permitAll() // Allow access
                        .requestMatchers("/api/other-employee/**").permitAll() // Allow access
                        .requestMatchers("/api/running-chart/**").permitAll() // Allow access
                        .requestMatchers("/api/statuses/**").permitAll() // Allow access
                        .requestMatchers("/api/roles/**").permitAll() // Allow access
                        .requestMatchers("/api/new/**").permitAll()
                        .requestMatchers("/api/auth/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin().disable()
                .httpBasic().disable();
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

//package com.company.motorcyclemanagement.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//import java.util.List;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Disable CSRF
//                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Enable CORS
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless session
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/accidents/**").permitAll() // Allow access
//                        .requestMatchers("/api/bike-employee/**").permitAll() // Allow access
//                        .requestMatchers("/api/branches/**").permitAll() // Allow access
//                        .requestMatchers("/api/insurance/**").permitAll() // Allow access
//                        .requestMatchers("/api/license/**").permitAll() // Allow access
//                        .requestMatchers("/api/maintenance/**").permitAll() // Allow access
//                        .requestMatchers("/api/motorcycle-allowance/**").permitAll() // Allow access
//                        .requestMatchers("/api/motorcycles/**").permitAll() // Allow access
//                        .requestMatchers("/api/other-employee/**").permitAll() // Allow access
//                        .requestMatchers("/api/running-chart/**").permitAll() // Allow access
//                        .requestMatchers("/api/statuses/**").permitAll() // Allow access
//                        .requestMatchers("/api/roles/**").permitAll() // Allow access
//                        .requestMatchers("/api/new/**").permitAll() // Allow access
//                        .requestMatchers("/api/auth/**").permitAll() // Allow access
//                        .requestMatchers("/**").permitAll() // Allow all other requests (for testing)
//                        .anyRequest().authenticated() // Secure all other endpoints
//                )
//                .formLogin().disable() // Disable form login
//                .httpBasic().disable(); // Disable HTTP Basic authentication
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowedOrigins(List.of("http://localhost:5173")); // Allow requests from this origin
//        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Allow these HTTP methods
//        config.setAllowedHeaders(List.of("*")); // Allow all headers
//        config.setAllowCredentials(true); // Allow credentials (cookies, authorization headers)
//        source.registerCorsConfiguration("/**", config); // Apply this CORS configuration to all endpoints
//        return source;
//    }
//}