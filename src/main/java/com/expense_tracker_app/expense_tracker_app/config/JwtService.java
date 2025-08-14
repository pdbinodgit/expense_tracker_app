package com.expense_tracker_app.expense_tracker_app.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtService {

    private final long EXPIRATION_TIME=1000*60*60*8;

    private static final String SECRET_KEY= "expense_tracker_and_income_tracker";

    private static final Key key= Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public String extractUsernameFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenValid(String token,String username){
        return extractUsernameFromToken(token).equals(username);
    }






}
