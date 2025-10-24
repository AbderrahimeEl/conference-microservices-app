package com.ms.authservice.controller;


import com.ms.authservice.dto.AuthRequest;
import com.ms.authservice.entity.User;
import com.ms.authservice.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    public AuthController(AuthenticationManager authenticationManager, AuthService service) {
        this.authenticationManager = authenticationManager;
        this.service = service;
    }

    private final AuthService service;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public String addNewUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
            return service.generateToken(authRequest.getUsername());
        } catch (Exception ex) {
            throw new RuntimeException("Invalid username or password");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }
}