package com.practice.jdbcjpa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	UserService userService;
	
		
	@Autowired
	private CustomOAuth2UserService oauthUserService;

	
// Does authorisation -- role based access 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
			.antMatchers("/oauth/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.oauth2Login()
			.userInfoEndpoint().userService(oauthUserService);
		
		
		// Handling successful google login 
		
		http.oauth2Login()
	    .userInfoEndpoint()
	    .userService(oauthUserService)
	    .and()
	    .successHandler(new AuthenticationSuccessHandler() {
	    	 

			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				CustomOAuth2User oauthUser =  (CustomOAuth2User) authentication.getPrincipal();
	            userService.processOAuthPostLogin(oauthUser.getEmail());
	 
//	            response.sendRedirect("/list");
				 
			}
	    });
	   
	
	}
	
	// Encoding password into database
	// Explore several encoders
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
}
