package com.elSurco.ElSurco_in5bv.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // Deshabilitar CSRF para poder hacer pruebas en Postman sin problemas
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        // 1. TAREA: Permisos para archivos CSS, imágenes y JS (Referencia del profe)
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/*.jpg", "/*.png").permitAll()

                        // 2. TAREA: Permisos a la ruta de register y login de El Surco
                        .requestMatchers("/api/auth/register", "/api/auth/login").permitAll()

                        // 3. Bloquear todo el resto del sistema (Requiere autenticación)
                        .anyRequest().authenticated()
                )
                // Estructura adicional que enseñó el profe:
                .formLogin(form -> form.permitAll())
                .logout(logout -> logout.permitAll())
                .build();
    }
}