package com.olx.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.User;
import com.olx.security.JwtUtil;
import com.olx.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;


import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/olx")
public class LoginController {
	
	 @Autowired
	 LoginService loginService;

	 @Autowired
	 AuthenticationManager authenticationManager;

	 @Autowired
	 JwtUtil jwtUtil;

	 @Autowired
	 UserDetailsService userDetailsService;
	
	@ApiOperation(value = "Authenticate user")
    @PostMapping(value = "/authenticate",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            if (authentication.isAuthenticated()) {
                String token = jwtUtil.generateToken(userDetailsService.loadUserByUsername(user.getUsername()));
                return new ResponseEntity<>(token, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            }
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
	
	
	// 2
    @ApiOperation(value = "Logs out authenticated user")
    @DeleteMapping(value = "/logout")
    public ResponseEntity<Boolean> logout(@RequestHeader("Authorization") String authToken) {

        ResponseEntity<Boolean> validTokenResponse = validateToken(authToken);
        if (Boolean.TRUE.equals(validTokenResponse.getBody())) {
            return new ResponseEntity<>(loginService.logout(authToken), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    // 3
    @ApiOperation(value = "Register a user")
    @PostMapping(value = "/register",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> registerUser(@RequestBody User user) {
        User newUser = loginService.registerUser(user);
        if (newUser != null) {
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // 4
    @ApiOperation(value = "Get info of a user")
    @GetMapping(value = "",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> getUserInfo(@RequestHeader("Authorization") String authToken) {

        ResponseEntity<Boolean> validTokenResponse = validateToken(authToken);
        if (Boolean.TRUE.equals(validTokenResponse.getBody())) {
            ResponseEntity<String> usernameResponse = getUsername(authToken);
            return new ResponseEntity<>(loginService.getUserInfo(usernameResponse.getBody()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    @ApiOperation(value = "validate token of a user")
    @GetMapping(value = "/validate/token")
    public ResponseEntity<Boolean> validateToken(@RequestHeader("Authorization") String authToken) {
        if(loginService.validateLogin(authToken)){
            return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        }
        try {
            String token = authToken.replace("Bearer ", "");
            String username = jwtUtil.extractUsername(token);
            if (username.isEmpty()) {
                return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
            }
            return new ResponseEntity<>(jwtUtil.validateToken(token, userDetailsService.loadUserByUsername(username)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Get username of a user")
    @GetMapping(value = "/name")
    public ResponseEntity<String> getUsername(@RequestHeader("Authorization") String authToken) {
        try {
            String token = authToken.replace("Bearer ", "");
            String username = jwtUtil.extractUsername(token);
            if (username.isEmpty()) {
                return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);
            }
            return new ResponseEntity<>(username, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }
    }

}
