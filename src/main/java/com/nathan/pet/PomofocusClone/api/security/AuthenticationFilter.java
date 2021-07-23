package com.nathan.pet.PomofocusClone.api.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.nathan.pet.PomofocusClone.api.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
  private static final Logger log = LogManager.getLogger(AuthenticationFilter.class);
  private final AuthenticationManager authenticationManager;

  public AuthenticationFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
    setFilterProcessesUrl("/login");
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
    throws AuthenticationException {
    try {
      User creds = new ObjectMapper().readValue(request.getInputStream(), User.class);
      log.debug("Authentication: " + creds.toString());
      return authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(creds.getName(), creds.getPassword(), new ArrayList<>()));
    } catch (IOException e) {
      throw new RuntimeException("Could ot read request" + e);
    }
  }

  protected void successfulAuthentication(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authentication)
  {
    String token = Jwts.builder()
        .setSubject(((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername())
        .setExpiration(new Date(System.currentTimeMillis() + 864_000_000))
        .signWith(SignatureAlgorithm.HS512, "SecretKeyToGenJWTs".getBytes())
        .compact();
    response.addHeader("Authorization","Bearer " + token);
  }
}
