package com.vamsi.LoginApp.config;


import com.vamsi.LoginApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        return http
                .authorizeHttpRequests(auth->
                        auth
                                .requestMatchers("/login/**").permitAll()
                                .requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
                                .requestMatchers("/user/**").hasAnyAuthority("ADMIN","USER")
                                .requestMatchers("/").permitAll()
                                .anyRequest().authenticated()
                        )
                .userDetailsService(userService)
                .formLogin(Customizer.withDefaults())
                .build();


    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }




}
