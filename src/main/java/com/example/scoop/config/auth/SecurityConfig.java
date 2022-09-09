package com.example.scoop.config.auth;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
import com.example.scoop.domain.Role;

@RequiredArgsConstructor
@EnableWebSecurity
@ConditionalOnDefaultWebSecurity
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class SecurityConfig {

	private final CustomOAuth2UserService customOAuth2UserService;

	   @Bean
	   @Order(SecurityProperties.BASIC_AUTH_ORDER)
	   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	       http
	               .csrf().disable()
	               .headers().frameOptions().disable() 
	               .and()
                   .authorizeRequests()
                   .antMatchers("/", "/css/**", "/img/**",
                           "/js/**", "/h2-console/**").permitAll()
                   .antMatchers("/api/v1/**").hasRole(Role.
                                                    USER.name())
                   .anyRequest().authenticated()
	               .and()
                   .logout()
                   .logoutUrl("/logout")
                   .logoutSuccessUrl("/").permitAll()
	               .and()
                   .oauth2Login()
                   .userInfoEndpoint()
                   .userService(customOAuth2UserService);
		return http.build();
	   }
}
