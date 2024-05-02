package com.eg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.csrf(csrf -> csrf.disable()).authorizeHttpRequests().requestMatchers("/public/hello").permitAll()
//				.anyRequest().authenticated().and().formLogin();

		httpSecurity.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/public/hello").permitAll().anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults());

	}

}
