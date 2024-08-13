package com.yezebi.pinpin.kaizoku.controller;

import com.yezebi.pinpin.kaizoku.dto.CreateUserDto;
import com.yezebi.pinpin.kaizoku.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;

  @PostMapping
  public String create(@Valid final CreateUserDto dto) {
    return authService.create(dto);
  }
}
