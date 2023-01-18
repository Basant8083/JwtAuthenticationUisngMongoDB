//package com.jwt.auth.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurtiyConfig {
//		
//	//in-memory authentication
//	
//	@Bean
//	public static PasswordEncoder passwordEncoder() {
//		
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		
//		http
//			.csrf()
//			.disable()
//			.cors()
//			.disable()
//			.authorizeHttpRequests((authorise) -> authorise
//			.anyRequest().authenticated())
//			.httpBasic(Customizer.withDefaults());
//			
//		return http.build();
//		
//	}
//	
////	inmemory spring security features provided by spring framework
////	@Bean
////	public UserDetailsService userDetailsService()
////	{
////		
////		UserDetails basant = User.builder()
////				.username("basant")
////				.password(passwordEncoder().encode("pandit"))
////				.roles("USER")
////				.build();
////		
////		
////		UserDetails admin = User.builder()
////				.username("admin")
////				.password(passwordEncoder().encode("admin"))
////				.roles("ADMIN" )
////				.build();
////		
////		
////		return new InMemoryUserDetailsManager(basant, admin); 
////		
////	}
//	
//	@Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//		UserDetails user = User.builder()
//            .username("basant")
//            .password(passwordEncoder().encode("pandit"))
//            .roles("ADMIN")
//            .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//	
//}
