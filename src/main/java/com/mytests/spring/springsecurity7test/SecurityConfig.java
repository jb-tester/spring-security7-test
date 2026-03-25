package com.mytests.spring.springsecurity7test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

import static org.springframework.security.web.util.matcher.RegexRequestMatcher.regexMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/home").permitAll()
                        .requestMatchers(HttpMethod.POST).hasAnyRole( "ADMIN", "USER")
                        .requestMatchers(regexMatcher("/admin/regex(\\d)*")).hasRole("MASTER") // regexp is not injected
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/registered/protected/**").access(new WebExpressionAuthorizationManager("hasRole('ADMIN') || hasRole('USER')"))
                        .requestMatchers("/registered/secured/**").access(new WebExpressionAuthorizationManager("hasRole('ADMIN') && hasRole('USER')"))
                       // .requestMatchers(antMatcher("/user/{uid}").access(new WebExpressionAuthorizationManager("@secutityUtil.checkUser(authentication,#uid)")))
                        //.requestMatchers(antMatcher("/api/user/**")).hasRole("USER")
                        .requestMatchers("/registered/**").not().hasRole("GUEST")
                        .requestMatchers("/registered/**").authenticated()
                        .requestMatchers(request -> request.getRequestURI().startsWith("/user/")).hasAuthority("ROLE_USER")
                        .requestMatchers(HttpMethod.POST, "/user/test1").hasRole( "USER")
                        .anyRequest().authenticated()
                );
               // .formLogin(Customizer.withDefaults());

        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER").build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN").build();
        UserDetails master = User.withDefaultPasswordEncoder()
                .username("master")
                .password("master")
                .roles("ADMIN","MASTER").build();
        UserDetails superuser = User.withDefaultPasswordEncoder()
                .username("super")
                .password("super")
                .roles("ADMIN", "USER").build();
        UserDetails guest = User.withDefaultPasswordEncoder()
                .username("guest")
                .password("guest")
                .roles("GUEST")
                .build();
        return new InMemoryUserDetailsManager(user, admin, guest);
    }
}