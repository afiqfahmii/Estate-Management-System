package com.project.estatemanagementsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private UserDetailsService userDetailsService;
    private AuthenticationSuccessHandler successHandler;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeRequests((authorize) ->
                        authorize.requestMatchers("/register/**", "/index", "/css/**", "/img/**", "/js/**", "/vendor/**", "/scss/**").permitAll()
                                .requestMatchers("/home").permitAll()
                                .requestMatchers("/users").hasRole("PEWARIS")
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/css/**", "/img/**", "/js/**", "/vendor/**", "/scss/**").permitAll()
                                .requestMatchers("/wasiat/create").hasAnyRole("PEWARIS","ADMIN")
                                .requestMatchers("/admin/list").hasAnyRole("PEWARIS","ADMIN")
                                .requestMatchers("/wasiat/update/**").hasAnyRole("PEWARIS","ADMIN")
                                .requestMatchers("/admin/delete/**").hasRole("ADMIN")

                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .successHandler(new SuccessHandler())
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}