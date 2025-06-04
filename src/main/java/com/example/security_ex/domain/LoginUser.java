package com.example.security_ex.domain;

import lombok.*;
import org.springframework.security.core.userdetails.User;

/**
 *  사용자 인증 정보 저장하기 위한 userdetails 구현 클래스
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {
  private String username;
  private String password;
  private String authority;
  private String displayname;
  private String phoneNumber;
}
