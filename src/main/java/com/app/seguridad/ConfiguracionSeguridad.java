package com.app.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class ConfiguracionSeguridad {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Deshabilita la protección CSRF y el encabezado HTTP Strict Transport Security (HSTS) para poder acceder a consola H2 ()
        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.authorizeHttpRequests()
                .requestMatchers("/registro").permitAll()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/img/**").permitAll()
                .requestMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
               // .and().logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
               // .and().rememberMe()
                .and().build();


    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

}
