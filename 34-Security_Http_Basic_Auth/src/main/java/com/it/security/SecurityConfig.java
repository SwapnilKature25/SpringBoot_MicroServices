package com.it.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
// purpose of this class is to customize spring security
@Configuration   
@EnableWebSecurity
public class SecurityConfig {
	
//	 used to represent our method type as spring bean
	@Bean   // It is used to represent that we are configuring one bean programmatically 
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
		// SecurityFilterChain  : to specify which urls should be secured and which should not
		http.authorizeHttpRequests( (request)->
			request.requestMatchers("/contact","/about","/swagger-ui.html").permitAll()
			.anyRequest().authenticated()
		).formLogin();
		
		return http.build();
	}
	
	@Bean    // InMemoryUserDetailsManager means configuring the users within the appl programmatically
	public InMemoryUserDetailsManager inMemoryUsers() {
		// InMemoryUserDetailsManager : Who can access our application
		UserDetails ashokUser = User.withDefaultPasswordEncoder()
			.username("ashok")
			.password("ashok")
			.authorities("ADMIN")   // means roles
			.build();
		
		UserDetails swapUser = User.withDefaultPasswordEncoder()
				.username("swap")
				.password("swap")
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(ashokUser, swapUser);
	}
	
	
	
	
}
