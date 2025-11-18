package com.khatep.tasktracker.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
    /*
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**", "/api/user/**").permitAll()
                .anyRequest().authenticated()
        )
                .httpBasic(httpBasic -> {});

        return http.build();
    }
    */

}
