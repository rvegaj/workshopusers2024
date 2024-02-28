package com.nisumcompany.workshopusers.infrastructure.configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
public class JwtUtils {
  @Value("${spring.jwt.secret}")
  private   String secret;

  public  String createToken(String userName) {
    return Jwts
        .builder()
        .setSubject(userName)
        .signWith(SignatureAlgorithm.HS256, secret)
        .compact();
  }

}
