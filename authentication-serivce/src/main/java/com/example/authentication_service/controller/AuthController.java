package com.example.authentication_service.controller;

import com.example.authentication_service.entity.User;
import com.example.authentication_service.service.AuthUserDetailsService;
import com.example.authentication_service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

        private final AuthenticationManager authenticationManager;
        private final AuthUserDetailsService userDetailsService;
        private final JwtUtil jwtUtil;

        @Autowired
        public AuthController(AuthenticationManager authenticationManager, AuthUserDetailsService userDetailsService, JwtUtil jwtUtil) {
            this.authenticationManager = authenticationManager;
            this.userDetailsService = userDetailsService;
            this.jwtUtil = jwtUtil;
        }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String , String > loginData) {
        try {
            String username = loginData.get("username");
            String password = loginData.get("password");

            System.out.println(" Attempting login for: " + username);

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            User user = userDetailsService.getUserByUsername(username);
            System.out.println(" User authenticated: " + username);

            String token = jwtUtil.generateToken(user.getUsername(), user.getRole());

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            response.put("role", user.getRole());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

        @PostMapping("/register")
        public ResponseEntity<User> registerUser(@RequestBody User user) {
            return ResponseEntity.ok(userDetailsService.registerUser(user));
        }
}
