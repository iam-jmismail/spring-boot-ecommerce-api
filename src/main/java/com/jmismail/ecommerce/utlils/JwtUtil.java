package com.jmismail.ecommerce.utlils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.*;

@Component
public class JwtUtil {

    private final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Generate Token
    public String generateToken(String email, TokenType tokenType) {

        int oneHourMs = 1000 * 60 * 60;
        int expiryTime = tokenType == TokenType.Access ? oneHourMs : oneHourMs * 8;

        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("roles", List.of("ROLE_ADMIN", "ROLE_USER"));

        return Jwts.builder()
                .setSubject(email)
                .addClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiryTime))
                .signWith(SECRET_KEY)
                .compact();
    }

    public String extractUserEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Claims extractClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Boolean isTokenExpired(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }

    public Boolean validateToken(String token, String email) {
        String extractedEmail = extractUserEmail(token);
        return (extractedEmail.equals(email) && !isTokenExpired(token));
    }
}
