package com.jmismail.ecommerce.controllers;

import com.jmismail.ecommerce.dto.LoginDto;
import com.jmismail.ecommerce.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid LoginDto loginDto){
        Map<String, String> tokens =  authService.loginUser(loginDto);

        return ResponseEntity.ok(Map.of(
                "message", "Success",
                "data", Map.of(
                        "accessToken", tokens.get("accessToken"),
                        "refreshToken", tokens.get("refreshToken")
                )
        ));
    }
}
