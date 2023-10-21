package com.bts.poc.facture.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.bts.poc.facture.security.jwt.AuthEntryPointJwt;
import com.bts.poc.facture.security.jwt.AuthTokenFilter;
import com.bts.poc.facture.security.services.UserDetailsServiceImpl;
import java.util.Arrays;

@Configuration
@EnableMethodSecurity

public class WebSecurityConfig { 
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				 .cors(Customizer.withDefaults())
				.exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth.requestMatchers("/api/v1/auth/**").permitAll()
						.requestMatchers("/api/v1/invoices/**").permitAll()
						// .requestMatchers("/api/auth/signin**").permitAll()
						.requestMatchers("/api/v1/test/**").permitAll().anyRequest().authenticated());

		http.authenticationProvider(authenticationProvider());

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	
	//un filtre : ajouter pour la relation entre frontend et backend	
	private CorsConfiguration buildConfig() {
	    CorsConfiguration corsConfiguration = new CorsConfiguration();
	    //corsConfiguration.addAllowedOrigin("*");
	    //  Cross domain configuration error , take .allowedOrigins Replace with .allowedOriginPatterns that will do .
	    //  Set the domain name that allows cross domain requests 
	    corsConfiguration.addAllowedOriginPattern("*");
	    corsConfiguration.addAllowedHeader("*");
	    //  Set allowed methods 
	    corsConfiguration.addAllowedMethod("*");
	    //  Whether to allow certificates 
	    corsConfiguration.setAllowCredentials(true);
	    //  Cross domain allow time 
	    corsConfiguration.setMaxAge(3600L);
	    return corsConfiguration;
	}

	@Bean
	public CorsFilter corsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", buildConfig());
	    return new CorsFilter(source);
	}
	
}
