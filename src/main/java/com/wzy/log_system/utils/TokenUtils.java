package com.wzy.log_system.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TokenUtils {
    private static long expire = 60480;
    private static String secret = "abcdefghijklmnopqrstuvwxyzabcdef";

    public static String getToken(String email){
        Date now = new Date();
        Date expiration = new Date(now.getTime()+1000*expire);

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }
    public static Claims getClaimsByToken(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

}
