package com.yezebi.pinpin.kaizoku.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseConfig {
  @Bean
  FirebaseApp firebaseApp(final AppProperties properties) {
    final var options =
        FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.applicationDefault)
            .setProjectId(properties.firebase.projectId)
            .build();

    return FirebaseApp.initializeApp(options);
  }

  @Bean
  FirebaseAuth firebaseAuth(final FirebaseApp firebaseApp) {
    return FirebaseAuth.getInstance(firebaseApp);
  }
}
