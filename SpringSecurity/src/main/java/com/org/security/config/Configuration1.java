package com.org.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class Configuration1 {


	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	

	@Bean(name = "authenticationManager")
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
	            throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails normalUsers=  User.withUsername("vishal").password(passwordEncoder().encode("vishal")).roles("NORMAL").build();
		
		UserDetails adminUsers=  User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
		
		InMemoryUserDetailsManager inMemoryUserDetailsManager=new InMemoryUserDetailsManager(normalUsers,adminUsers);
		
		return inMemoryUserDetailsManager;
	}
}
