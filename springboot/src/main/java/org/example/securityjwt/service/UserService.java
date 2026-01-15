package org.example.securityjwt.service;

import org.example.securityjwt.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  public UserDto getUser() {
    return new UserDto("Manish", "USER");
  }
}
