package com.yezebi.pinpin.kaizoku;

import com.yezebi.pinpin.kaizoku.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class KaizokuApplication {
  public static void main(String[] args) {
    SpringApplication.run(KaizokuApplication.class, args);
  }
}
