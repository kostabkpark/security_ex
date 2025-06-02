package com.example.security_ex.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 *  사용자 인증 정보 저장하기 위한 userdetails 구현 클래스
 */
@Getter
//@Builder
public class LoginUser extends User {
  private String displayname;
  private String phoneNumber;

  public LoginUser(
      String username,
      String password,
      Collection<? extends GrantedAuthority> authorities,
      String displayname,
      String phoneNumber) {
    super(username, password, authorities);
    this.displayname = displayname;
    this.phoneNumber = phoneNumber;
  }
 // [ 추가한 필드에 대한 Getter 부분 ] ==> @Getter 로 대체
}
