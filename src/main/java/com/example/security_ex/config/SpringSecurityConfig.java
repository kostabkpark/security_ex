package com.example.security_ex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(req -> req
              .requestMatchers("/login").permitAll()
              .anyRequest().authenticated())
        .csrf(csrf -> csrf.disable())
        .formLogin(form -> form.loginPage("/login")
              .loginProcessingUrl("/login_process")
              .usernameParameter("userid")
              .passwordParameter("pwd")
              .failureUrl("/login?error")
              .defaultSuccessUrl("/"))
         .logout(Customizer.withDefaults());
    return http.build();
  }
}
