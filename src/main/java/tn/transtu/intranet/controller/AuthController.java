package tn.transtu.intranet.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.transtu.intranet.dto.LoginRequest;
import tn.transtu.intranet.dto.LoginResponse;
import tn.transtu.intranet.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	 private final AuthService authService;
	 public AuthController(AuthService authService) {
	        this.authService = authService;
	 }
	 @PostMapping("/login")
	 public LoginResponse login(@RequestBody LoginRequest request) {
	     String token = authService.login(request.getUsername(), request.getPassword());
	        return new LoginResponse(token);
	    }
	 

}
