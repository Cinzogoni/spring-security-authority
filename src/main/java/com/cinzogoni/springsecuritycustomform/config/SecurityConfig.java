package com.cinzogoni.springsecuritycustomform.config;

import com.cinzogoni.springsecuritycustomform.service.CustomUserDetailsService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@Getter
@Setter
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        AccessDeniedHandlerImpl accessDeniedHandler = new AccessDeniedHandlerImpl();
        accessDeniedHandler.setErrorPage("/access-denied");

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                        .requestMatchers("/employees/showForm").hasAnyRole("ADMIN","MANAGER")
                        .requestMatchers("/employees/showForm").hasAnyRole("ADMIN","MANAGER")
                        .requestMatchers("/employees/delete").hasAnyRole("ADMIN")
                        .requestMatchers("/employees/**").hasAnyRole("EMPLOYEE")
                        .requestMatchers("/resources/**")
                        .permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .successHandler(customAuthenticationSuccessHandler())
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll)
                .exceptionHandling(exception -> exception
                        .accessDeniedHandler(accessDeniedHandler)

                )
                .userDetailsService(userDetailsService);
        return http.build();
    }

    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return (request, response, authentication) -> {
            String redirectUrl = "/home";
            response.sendRedirect(redirectUrl);
        };
    }
}
