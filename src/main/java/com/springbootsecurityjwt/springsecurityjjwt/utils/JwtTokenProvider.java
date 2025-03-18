package com.springbootsecurityjwt.springsecurityjjwt.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${security.jwt.secret}")
    private String jwtSecret;

    @Value("${security.jwt.expiry}")
    private long jwtExpirationDate;

    public String decodeJWTToken(String token) {
        String[] chunks = token.split("\\.");

        String header = new String(Decoders.BASE64.decode(chunks[0]));
        String payload = new String(Decoders.BASE64.decode(chunks[1]));
        System.out.println("Printing decodedToken: "+header + " " + payload);
        return header + " " + payload;
    }

    public String generateToken(Authentication authentication){

        String username = authentication.getName();

        Date currentDate = new Date();

        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

        String token = Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(expireDate)
                .signWith(key())
                .compact();

        return token;
    }

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String getUsername(String token){

        return Jwts.parser()
                .verifyWith((SecretKey) key())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

//    Date expiration = Jwts.parser()
//            .setSigningKey(key())
//            .parseClaimsJws(token)
//            .getBody()
//            .getExpiration();

    public boolean validateToken(String token){
        decodeJWTToken(token);
        Jwts.parser()
                .verifyWith((SecretKey) key())
                .build()
                .parse(token);
        return true;

    }
}