package com.ecom.flipkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.flipkart.beans.UserCredentialDTO;
import com.ecom.flipkart.service.UserCredentialsService;

@RestController
@RequestMapping("/user")
public class UserCredentialsController {

	@Autowired
	UserCredentialsService userCredentialsService;
	
	@PostMapping("/register")
	public ResponseEntity<String> userRegistration(@RequestBody UserCredentialDTO user){
		return userCredentialsService.userRegistration(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody UserCredentialDTO user){
		return userCredentialsService.userLogin(user);
	}
}
