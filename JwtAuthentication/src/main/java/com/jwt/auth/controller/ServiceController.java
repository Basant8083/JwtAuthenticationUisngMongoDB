package com.jwt.auth.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.auth.model.Employee;
import com.jwt.auth.model.JwtRequest;
import com.jwt.auth.model.JwtResponse;
import com.jwt.auth.repo.EmployeeRepo;
import com.jwt.auth.services.CustomUserDetailsService;
import com.jwt.auth.util.JwtUtil;

@RestController
@RequestMapping("/token")
public class ServiceController {
	
//	token validate
	@Autowired
	private AuthenticationManager authenticationManager;
	
//	jwt util class for generating token
	@Autowired
	private JwtUtil jwtUtil;
	
//	for aceesing user info
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest jwtRequest ) throws Exception{
//		validate token using authentication manager
		try {
			this.authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
		} catch(UsernameNotFoundException e) {
			
			e.printStackTrace();
			throw new Exception("Bad Credentials.!");
		}
		
//		fine area
		UserDetails userDetails = 	 this.customUserDetailsService.loadUserByUsername(jwtRequest.getUserName());
		
		
		String token = this.jwtUtil.generateToken(userDetails);
		
		System.out.println("JWT TOken "+token);
//		return {tokenName : "token"}
		
		return ResponseEntity.ok(new JwtResponse(token));
		
	}

	
	
//	@GetMapping
//	public String sayHello()
//	{
//		String Text = "Hi this is text string and it will not be accessible by ";
//		
//		Text += "unauthorised user...";
//		return Text;
//	}
//	@PostMapping("/")
//	public ResponseEntity<Employee> postEmployeeEntity(@RequestBody Employee employee )
//	{
//		return ResponseEntity.ok(employeeRepo.save(employee));
//	}
//	
//	@GetMapping("/all")
//	public ResponseEntity<List<Employee>> getEmployeeEntity()
//	{
//		return ResponseEntity.ok(employeeRepo.findAll());
//	}
//	
//
//	@GetMapping("/all/{emp_id}")
//	public ResponseEntity<Optional<Employee>> getEmployeById(@PathVariable("emp_id") Integer id)
//	{				
//		return ResponseEntity.ok(employeeRepo.findById(id));
//	}
	
	
	
}
