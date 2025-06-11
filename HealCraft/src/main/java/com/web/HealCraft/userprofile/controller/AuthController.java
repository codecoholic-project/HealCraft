package com.web.HealCraft.userprofile.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.HealCraft.userprofile.bean.JwtUtils;
import com.web.HealCraft.userprofile.dao.UserRepository;
import com.web.HealCraft.userprofile.dto.JwtResponse;
import com.web.HealCraft.userprofile.dto.LoginRequest;
import com.web.HealCraft.userprofile.dto.RegisterRequest;
import com.web.HealCraft.userprofile.entity.UserEntity;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        if (userRepository.findByEmail(request.email).isPresent()) {
            return ResponseEntity.badRequest().body("Email already registered");
        }

        UserEntity user = new UserEntity();
        user.setUserType("CUSTOMER");
        user.setFirstName(request.firstName);
        user.setLastName(request.lastName);
        user.setAddress(request.address);
        user.setEmail(request.email);
        user.setPhone(request.phone);
        user.setCountry(request.country);
        user.setCity(request.city);
        user.setDob(request.dateOfBirth);
        user.setMaritalStatus(request.maritalStatus);
        user.setGender(request.gender);
        user.setPassword(passwordEncoder.encode(request.password));
        user.setEnabled(true);
        user.setCreatedOn(LocalDateTime.now());
        user.setUpdatedOn(LocalDateTime.now());

        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.email, request.password)
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token, userDetails.getUsername()));
    }
}
