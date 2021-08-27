package com.org.security.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.org.security.jwt.JwtProvider;
import com.org.security.model.EmailRequestDto;
import com.org.security.model.SavingsAccount;
import com.org.security.model.User;
import com.org.security.model.User_Role;
import com.org.security.repository.SavingsRepository;
import com.org.security.repository.UserRepository;
import com.org.security.repository.User_RoleRepository;
import com.org.security.request.LoginForm;
import com.org.security.request.PasswordResetRequest;
import com.org.security.request.SignUpForm;
import com.org.security.response.JwtResponse;
import com.org.security.response.ResponseMessage;
import com.org.security.service.AccessServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")


public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	AccessServiceImpl accessAervice;
	
	@Autowired
	User_RoleRepository userRoleRepository;
	
	@Autowired
	SavingsRepository savingsRepository;
	
	

	EmailRequestDto email = null;
	
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		System.out.println(loginRequest.getUsername());
		System.out.println(loginRequest.getPassword());
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		User data=accessAervice.getByEmailId(loginRequest.getUsername());
		

		return ResponseEntity.ok(new JwtResponse(data.getId(),data.getName(),jwt, userDetails.getUsername(),data.getMobile(),data.getGender(), userDetails.getAuthorities()));
	}
	

//	@PostMapping("/signin")
//	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
//
//		System.out.println(loginRequest.getUsername());
//		System.out.println(loginRequest.getPassword());
//		Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//
//		String jwt = jwtProvider.generateJwtToken(authentication);
//		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//		User data=accessAervice.getByEmailId(loginRequest.getUsername());
//		
//
//		return ResponseEntity.ok(new JwtResponse(data.getId(),data.getName(),jwt, userDetails.getUsername(),data.getMobile(),data.getGender(), userDetails.getAuthorities()));
//	}
	
	
	@PutMapping("/reset/{id}")
	public String passwordReset(@PathVariable("id") String id,@RequestBody PasswordResetRequest passwordResetRequest) throws Exception {
		return accessAervice.resetPasswordById(id, passwordResetRequest);
	}
	
	
	
	//NEW USER REGISTRATION 
		@PostMapping("/signup")
		public ResponseEntity<?> registerUser(@RequestBody SignUpForm signUpRequest) {
			System.out.println(signUpRequest);
//			if (userRepository.existsByUsername(signUpRequest.getName())) {
//				return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
//						HttpStatus.BAD_REQUEST);
//			}

			if (userRepository.existsByEmailId(signUpRequest.getEmailId())) {
				return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
						HttpStatus.BAD_REQUEST);
			}

			// Creating user's account
			User user = new User();
//			
			user.setName(signUpRequest.getName());
			user.setEmailId(signUpRequest.getEmailId());
			user.setGender(signUpRequest.getGender());
			user.setMobile(signUpRequest.getMobile());
			user.setAdhar_number(signUpRequest.getAdhar_number());
			user.setPan(signUpRequest.getPan());
			user.setPassword(encoder.encode(signUpRequest.getPassword()));
			
			
			
			
			SavingsAccount newAccount = new SavingsAccount();
			BigDecimal defaultAccountBalance = new BigDecimal(0);
			newAccount.setAccountBalance(defaultAccountBalance);
			
			Random random = new Random();
			int autoGeneratedAccountNumber = random.nextInt(10000);
			
			newAccount.setAccountNumber(autoGeneratedAccountNumber);
			
			savingsRepository.save(newAccount);
			SavingsAccount savedAccount = savingsRepository.findByAccountNumber(autoGeneratedAccountNumber);
			
			
			
			user.setSavings_account_number(savedAccount.getAccountNumber());
			
			

			userRepository.save(user);
			
			//SETTING DEFAULT ROLE
			String defaultRole = "3";
			String userId = String.valueOf(user.getId());
			User_Role userRole = new User_Role(userId, defaultRole);
			userRoleRepository.save(userRole);
			
		
			
		
			return new ResponseEntity<>(user, HttpStatus.OK);
		}

	
	
	
	
	

	

}