package org.example.securityjwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        // Stateless API
        .csrf(csrf -> csrf.disable())
        // Authorization rules
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/public/**").permitAll()
            .requestMatchers("/api/admin/**").hasRole("ADMIN")
            .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN")
            .anyRequest()
            .authenticated()
        )
        // OAuth2 Resource Server (JWT)
        .oauth2ResourceServer(oauth2 ->
            oauth2.jwt(jwt ->
                jwt.jwtAuthenticationConverter(new JwtAuthConverter())
            )
        );

    return httpSecurity.build();
  }
}
