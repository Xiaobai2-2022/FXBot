package com.fangxia.fxbot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "private.server")
public class PrivateServerConfig {
    private String key;
}
