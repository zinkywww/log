package com.wzy.log_system;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.wzy.log_system.entity.Article;
import com.wzy.log_system.entity.User;
import com.wzy.log_system.mapper.ArticleMapper;
import com.wzy.log_system.mapper.UserMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.classpath.ClassPathFileSystemWatcher;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;

//@SpringBootTest
class LogSystemApplicationTests {

    @Test
    void genJWT(){
        HashMap<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","kobe");
        String jwt=Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"abcdefghijklmnopqrstuvwxyzabcdef")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void parseJWT(){
        Claims claims =Jwts.parser()
                .setSigningKey("abcdefghijklmnopqrstuvwxyzabcdef")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzIyMzE0MDQwLCJ1c2VybmFtZSI6ImtvYmUifQ.CFI0I5Xs_boeQDP30zp9s38YOfPogGAA2cuQ_PQKViw")
                .getBody();
        System.out.println(claims);
    }







}
