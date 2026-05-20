package com.elSurco.ElSurco_in5bv.Config;

import com.elSurco.ElSurco_in5bv.Entity.User;
import com.elSurco.ElSurco_in5bv.Repository.UserRepository;
import com.elSurco.ElSurco_in5bv.Repository.FarmerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository, FarmerRepository farmerRepository) {
        return username -> {

            if ("admin@elsurco.com".equals(username) || "admin".equals(username)) {
                return org.springframework.security.core.userdetails.User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("1234"))
                        .roles("ADMIN")
                        .build();
            }

            User user = userRepository.findByUserEmail(username)
                    .orElseGet(() -> userRepository.findByHandle(username)
                            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con: " + username)));

            // Aplicamos la lógica de roles dinámicos para los usuarios de la DB
            String rolAsignado = "BUYER";
            if (farmerRepository.existsByUser(user)) {
                rolAsignado = "FARMER";
            }

            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUserEmail())
                    .password(user.getUserPassword()) // Hash real extraído de la DB
                    .roles(rolAsignado)
                    .build();
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register", "/login", "/css/**", "/js/**", "/img/**", "/home", "/shop/**").permitAll()
                        .requestMatchers("/farmer/register").authenticated()
                        .requestMatchers("/farmer/**").hasRole("FARMER")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }
}