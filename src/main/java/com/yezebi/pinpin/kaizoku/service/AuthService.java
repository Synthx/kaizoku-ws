package com.yezebi.pinpin.kaizoku.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.yezebi.pinpin.kaizoku.dto.CreateUserDto;
import com.yezebi.pinpin.kaizoku.entity.User;
import com.yezebi.pinpin.kaizoku.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final FirebaseAuth firebaseAuth;
  private final MailingService mailingService;
  private final UserRepository userRepository;

  @Transactional
  public String create(final CreateUserDto dto) {
    if (userRepository.existsByEmailIgnoreCase(dto.email)) {
      throw new IllegalArgumentException("email already exists");
    }

    final var request =
        new UserRecord.CreateRequest().setEmail(dto.email).setPassword(dto.password);

    final var record = firebaseAuth.createUser(request);
    final var user = User.builder().id(record.uid).email(dto.email).name(dto.name).build();

    userRepository.save(user);

    return record.uid;
  }

  public void sendEmailVerification(final String email) {
    final var user = userRepository.findByEmailIgnoreCase(email);
    if (user == null) {
      return;
    }

    mailingService.sendEmailVerification(user);
  }

  public void sendPasswordResetEmail(final String email) {
    final var user = userRepository.findByEmailIgnoreCase(email);
    if (user == null) {
      return;
    }

    mailingService.sendPasswordReset(user);
  }
}
