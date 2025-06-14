package com.example.security_ex.service;

import com.example.security_ex.domain.LoginUser;
import com.example.security_ex.domain.Users;
import com.example.security_ex.repository.UsersMapperRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginUserDetailsServiceImpl implements UserDetailsService {
  private final UsersMapperRepository usersMapperRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // 인증 사용자 정보 테이블에서 로그인시 입력한 username 으로 사용자 정보 가져오기
    log.info("loadUserByUsername 1 ===> {}", username);
    Users user = usersMapperRepository.findByUsername(username);
    // 사용자 정보가 없으면 null (익셉션), 있으면 LoginUser 생성해서 반환
    if(user == null) {
      log.info("loadUserByUsername 2 ===> {}", user);
      return null;
    } else {
      log.info("loadUserByUsername 3 ===> {}", user.getUsername());
      return User.builder()
          .username(user.getUsername())
          .password(user.getPassword())
          .roles(user.getAuthority())
          .build();
    }
  }
}
