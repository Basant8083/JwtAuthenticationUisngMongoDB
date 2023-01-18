package com.jwt.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.jwt.auth.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//        	.cors().disable()
//        	.authorizeHttpRequests()
//        	.anyRequest()
//        	.authenticated()
//        	.and()
//        	.exceptionHandling()
//        	.authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
//        	.and()
//        	.sessionManagement()
//        	.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		http
//
//			  .authorizeHttpRequests()
//			  .requestMatchers("/token/**").permitAll() //antMathcer is removed from spring boot-->
//			  .anyRequest().authenticated()
//			  .and()
//			  .exceptionHandling()
//			  .authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
//			  .and()
//			  .sessionManagement()
//			  .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
			http
			.csrf()
			.disable()
			.cors()
			.disable()
			.authorizeHttpRequests((authorise) -> authorise.anyRequest().authenticated())
			.httpBasic(Customizer.withDefaults());
		
        
       
        return http.build();
    }
	
	@Bean
	public static PasswordEncoder passwordEncoder()
	{
//		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		passwordEncoder.encode("Pandit");
		
		return new BCryptPasswordEncoder();
	}
	
//	provide access to user
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(this.customUserDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		
		return provider;
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	
//	@Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//		UserDetails user = User.builder()
//            .username("basant")
//            .password(passwordEncoder().encode("jksdnvsdkjbsdxvdfkjvbdkndsnkjavskjvkfjvbmfkmmvhjkjsdjkcsdfbksddfkjfnsdkcfn"))
//            .roles("ADMIN")
//            .build();
//        return new InMemoryUserDetailsManager(user);
//    }

   
}
