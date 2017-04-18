package br.com.eteg.opbp.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
  @Autowired
  private AuthenticationManager authenticationManager;

  @PostMapping(value = "/login")
  public ResponseEntity<?> login(@RequestParam("username") String username,
      @RequestParam("password") String password, HttpServletRequest request) {
    try {
      final Authentication authenticationToken =
          new UsernamePasswordAuthenticationToken(username, password);

      final Authentication authentication = authenticationManager.authenticate(authenticationToken);

      final SecurityContext securityContext = SecurityContextHolder.getContext();
      securityContext.setAuthentication(authentication);

      final HttpSession session = request.getSession(true);
      session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
      
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (AuthenticationException e) {
      return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
  }
}
