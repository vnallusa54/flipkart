package com.ecom.flipkart.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecom.flipkart.beans.UserCredentialDTO;
import com.ecom.flipkart.entity.UserCredentialsEntity;
import com.ecom.flipkart.repository.UserCredentialsRepository;
import com.ecom.flipkart.service.UserCredentialsService;

@Service
public class UserCredentialsServiceImpl implements UserCredentialsService{

	@Autowired
	UserCredentialsRepository userCredentialsRepository;
	
	@Override
	public ResponseEntity<String> userRegistration(UserCredentialDTO user) {
		UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
		BeanUtils.copyProperties(user, userCredentialsEntity);
		try {
		userCredentialsRepository.save(userCredentialsEntity);
		} catch (Exception e) {
			return 	new ResponseEntity<String>("Registration Failed Please try again", HttpStatus.CONFLICT);
		}
	return 	new ResponseEntity<String>("User Registered Successfully", HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<?> userLogin(UserCredentialDTO user) {
		Optional<UserCredentialsEntity> userCredentialEntity = userCredentialsRepository.findByUserId(user.getUserId());
		if(userCredentialEntity.isPresent()) {
			if(user.getPassword().equals(userCredentialEntity.get().getPassword())) {
				return 	new ResponseEntity<String>("User Logged in Successfully", HttpStatus.ACCEPTED);
			} else {
				return 	new ResponseEntity<String>("Incorrect Password", HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			return 	new ResponseEntity<String>("UserId is not available Please try to Register", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	

}
