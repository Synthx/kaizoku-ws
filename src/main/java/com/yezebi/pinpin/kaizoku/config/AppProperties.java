package com.yezebi.pinpin.kaizoku.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public record AppProperties(
        Email email,
        Firebase firebase
) {
    public record Email(String name) {
    }

    public record Firebase(String projectId) {
    }
}
