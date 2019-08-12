package com.ecom.flipkart.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecom.flipkart.beans.UserCredentialDTO;

@Service
public interface UserCredentialsService {
	public ResponseEntity<String> userRegistration(UserCredentialDTO user);
	
	public ResponseEntity<?> userLogin(UserCredentialDTO user);
	
	public ResponseEntity<?> userDeletion(UserCredentialDTO user);
}
