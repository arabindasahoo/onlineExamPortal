package com.exam.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.config.JwtUtil;
import com.exam.exceptions.UserNotFoundException;
import com.exam.model.JwtRequest;
import com.exam.model.JwtResponse;
import com.exam.model.User;
import com.exam.service.impl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

	@Autowired
	private AuthenticationManager AuthenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private JwtUtil jwtUtils;
	
	
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest request) throws Exception
	{
		try {
			
			authenticate(request.getUsername(), request.getPassword());
			
			
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			throw new Exception("USER NOT FOUND");
		
		}
		
		
		//USER AUTHENTICATED
		
		
		UserDetails user = this.userDetailsServiceImpl.loadUserByUsername(request.getUsername());
		
		String Token = jwtUtils.generateToken(user);
		
		return ResponseEntity.ok(new JwtResponse(Token));
	}
	
	

	private void authenticate(String username, String password) throws Exception {
		try {

			AuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		} catch (DisabledException e) {

			throw new Exception("USER DISABLED " + e.getMessage());

		}

		catch (BadCredentialsException e) {

			throw new Exception("Invalid Creadentials " + e.getMessage());

		}
	}

	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal)
	{
		return (User) userDetailsServiceImpl.loadUserByUsername(principal.getName());
	}
	
}
