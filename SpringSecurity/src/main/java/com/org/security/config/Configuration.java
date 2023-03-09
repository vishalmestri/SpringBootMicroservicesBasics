package com.org.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.org.security.filter.JwtRequestFilter;

@org.springframework.context.annotation.Configuration
@EnableWebSecurity(debug = true)
public class Configuration {
	
	@Autowired
	public JwtRequestFilter jwtRequestFilter;


	
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
	/*	httpSecurity.csrf().disable().
					authorizeHttpRequests()
					.requestMatchers("/mysite/home")
					.permitAll()
					.anyRequest().authenticated()
					.and()
					.formLogin();
		*/
		
		httpSecurity.csrf().disable().
		authorizeHttpRequests()
		.requestMatchers("/mysite/home/normalUser/**").hasRole("NORMAL")
		.requestMatchers("/mysite/home/adminUser/**").hasRole("ADMIN")
		.requestMatchers("/mysite/home","/mysite/authenticate").permitAll()
		.anyRequest().authenticated()
		.and()
		.exceptionHandling().and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class); 
		return httpSecurity.build();
	}
}
