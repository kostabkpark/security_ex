package com.example.security_ex.controller;

import com.example.security_ex.dto.UserSignInDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class MemberController {


  @GetMapping
  public String menu() {
    return "menu";
  }

  @GetMapping("/todos")
  public String todos() {
    return "todos";
  }
}
