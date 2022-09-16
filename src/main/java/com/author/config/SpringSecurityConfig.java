//package com.author.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@SuppressWarnings("deprecation")
//@Configuration
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication().withUser("Author").password("author123").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("Reader").password("reader123").roles("USER");
//	}
//	
//	protected void configure(HttpSecurity http) throws Exception{
//		http.csrf().disable();
//		http.authorizeRequests().antMatchers("/author/**").hasAnyRole("ADMIN").anyRequest().fullyAuthenticated().and()
//		.httpBasic();
//	}
//
//}
