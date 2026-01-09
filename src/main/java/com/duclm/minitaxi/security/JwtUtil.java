package com.duclm.minitaxi.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import com.duclm.minitaxi.config.CustomUserDetails;


@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.refresh-secret}")
    private String refreshSecretKey;

    @Value("${jwt.expiration}")
    private long accessTokenValidity;

    @Value("${jwt.refresh-expiration}")
    private long refreshTokenValidity;

    private Key accessKey;
    private Key refreshKey;

    public enum TokenType {
        ACCESS, REFRESH
    }

    @PostConstruct
    public void init() {
        this.accessKey = Keys.hmacShaKeyFor(secretKey.getBytes());
        this.refreshKey = Keys.hmacShaKeyFor(refreshSecretKey.getBytes());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        if (userDetails instanceof CustomUserDetails) {
            CustomUserDetails cud = (CustomUserDetails) userDetails;
            claims.put("id", cud.getUser().getId());
        }
        return createToken(claims, userDetails.getUsername(), accessTokenValidity, accessKey);
    }

    public String generateRefreshToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        if (userDetails instanceof CustomUserDetails) {
            CustomUserDetails cud = (CustomUserDetails) userDetails;
            claims.put("id", cud.getUser().getId());
        }
        return createToken(claims, userDetails.getUsername(), refreshTokenValidity, refreshKey);
    }

    private String createToken(Map<String, Object> claims, String subject, long expiration, Key signKey) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(signKey, SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey(TokenType type) {
        return type == TokenType.REFRESH ? refreshKey : accessKey;
    }

    public String extractUsername(String token, TokenType type) {
        return getClaims(token, getKey(type)).getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails, TokenType type) {
        Key key = getKey(type);
        return extractUsername(token, type).equals(userDetails.getUsername())
                && !isExpired(token, key);
    }

    private boolean isExpired(String token, Key signKey) {
        return getClaims(token, signKey).getExpiration().before(new Date());
    }

    private Claims getClaims(String token, Key signKey) {
        return Jwts.parserBuilder()
                .setSigningKey(signKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}