package com.org.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.security.model.AuthenticationRequest;
import com.org.security.model.AuthenticationResponse;
import com.org.security.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/mysite")
public class HomeController {

	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@GetMapping("/home")
	@ResponseBody
	public String homeWithoutLogin() {
		return "home withtout login";
	}
	
	@GetMapping("/home/normalUser")
	@ResponseBody
	public String homeLoginWithNormalUser() {
		log.info("homeLoginWithNormalUser=>reached... here....");
		return "home login with normal user";
	}
	
	@GetMapping("/home/adminUser")
	@ResponseBody
	public String homeLoginWithAdminUser() {
		return "home login with admin user";
	}
	
	
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			log.info("createAuthenticationToken-1");
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
				log.info("Incorrect username or password"+e.getMessage());
			return ResponseEntity.ok(new AuthenticationResponse("Incorrect username or password"+e.getMessage()));
		}
		catch (Exception e1) {
			log.info("exception="+e1.getMessage());
		return ResponseEntity.ok(new AuthenticationResponse("exception="+e1.getMessage()));
	}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
