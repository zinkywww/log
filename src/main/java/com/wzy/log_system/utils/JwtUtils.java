package com.wzy.log_system.utils;

import com.wzy.log_system.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;
import java.util.SplittableRandom;

public class JwtUtils {
    private static long expire = 60480;
    private static String secret = "abcdefghijklmnopqrstuvwxyzabcdef";

    public static String genJwt(Map<String, Object> claims) {
        String jwt = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256,secret)
                .setExpiration(new Date(System.currentTimeMillis() + 1000*expire))
                .compact();
        return jwt;
    }

    public static Claims parseJwt(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }

}
