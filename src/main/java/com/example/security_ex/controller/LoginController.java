package com.example.security_ex.controller;

import com.example.security_ex.service.LoginUserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
  private final UserDetailsService userDetailsService;

  @GetMapping
  public String login() {
    return "login";
  }
}
