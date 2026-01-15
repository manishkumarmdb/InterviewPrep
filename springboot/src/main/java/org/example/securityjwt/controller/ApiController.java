package org.example.securityjwt.controller;

import org.example.securityjwt.dto.UserDto;
import org.example.securityjwt.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

  private final UserService userService;

  public ApiController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/public")
  public String publicApi() {
    return "Public API – No Authentication Required";
  }

  @PreAuthorize("hasRole('USER')")
  @GetMapping("/user")
  public UserDto getUserDto() {
    return userService.getUser();
  }

  @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
  @GetMapping("/manage")
  public String manage() {
    return "Admin/Manager Access Granted";
  }
}
