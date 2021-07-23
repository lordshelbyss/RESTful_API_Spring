//package com.practice.jdbcjpa;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		auth.inMemoryAuthentication()
//			.withUser("Sam")
//			.password("Sam")
//			.roles("User");
//	}
//
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		// TODO Auto-generated method stub
////		http.authorizeRequests()
////			.antMatchers("/note_taking_app/notes").hasRole("User")
////			.antMatchers("note_taking_app").permitAll();
////	}
////	
//	@Bean
//	public PasswordEncoder passwordEncoder()
//	{
//		return new BCryptPasswordEncoder();
//	}
//	
//}
