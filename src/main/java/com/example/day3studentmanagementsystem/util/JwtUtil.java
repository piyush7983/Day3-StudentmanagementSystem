package com.example.day3studentmanagementsystem.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET = "abfaefjebjfaejbfjaesdbnf";

    private final Key key = Keys.hmacShaKeyFor(
            SECRET.getBytes(StandardCharsets.UTF_8));

    // TOKEN GENERATE
    public String generateToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 60) // 1 hour
                )
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // TOKEN VALIDATE + EMAIL EXTRACT
    public String validateTokenAndGetEmail(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
