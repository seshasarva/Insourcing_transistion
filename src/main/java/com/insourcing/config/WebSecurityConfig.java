package com.insourcing.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.insourcing.jwt.security.JWTAuthorizationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String[] NON_AUTH_APIS = { "/api/authenticate", "/api/logout", "/hrbc/login" };
	private static final String[] NON_AUTH_SWAGGER_APIS = { "/v2/api-docs/**", "/swagger.json", "/swagger-ui.html",
			"/swagger-resources/**", "/webjars/**" };

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(NON_AUTH_SWAGGER_APIS);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.csrf().disable().addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests().antMatchers(HttpMethod.POST, NON_AUTH_APIS).permitAll().anyRequest()
				.authenticated();*/
		http.csrf().disable();
	}
}