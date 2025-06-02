package com.example.security_ex.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
  private String username;
  private String password;
  private Role authority;
  private String displayname;
  private String phoneNumber;
}
