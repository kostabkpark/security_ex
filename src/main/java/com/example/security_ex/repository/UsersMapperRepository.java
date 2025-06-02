package com.example.security_ex.repository;

import com.example.security_ex.domain.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersMapperRepository {
  // 사용자 이름으로 로그인 사용자 정보를 조회하는 기능 추가

  @Select("select username, password, authority, displayname, phoneNumber from users where username=:username")
  public Users findByUsername(String username);
}
