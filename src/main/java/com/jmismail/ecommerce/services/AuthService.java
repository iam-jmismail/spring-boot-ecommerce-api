package com.jmismail.ecommerce.services;

import com.jmismail.ecommerce.dto.LoginDto;
import com.jmismail.ecommerce.utlils.JwtUtil;
import com.jmismail.ecommerce.utlils.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private JwtUtil jwtUtil;

    public Map<String, String> loginUser(LoginDto loginDto){


        String accessToken = jwtUtil.generateToken(loginDto.getEmail(), TokenType.Access);
        String refreshToken = jwtUtil.generateToken(loginDto.getEmail(), TokenType.Refresh);

        Map<String, String> response = new HashMap<>();
            response.put("accessToken",accessToken);
            response.put("refreshToken", refreshToken);
            return  response;
    }
}
