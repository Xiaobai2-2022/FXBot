package com.fangxia.fxbot.security;

import com.fangxia.fxbot.config.PrivateServerConfig;
import com.fangxia.fxbot.common.FXApiResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FXSecurityKey {

    private final PrivateServerConfig privateServerConfig;

    public FXApiResponse<?> validate(String providedKey) {
        if(providedKey == null) {
            return FXApiResponse.illegal("Missing Server Key");
        } else if(!providedKey.equals(privateServerConfig.getKey())) {
            return FXApiResponse.illegal("Invalid Server Key");
        }
        return FXApiResponse.success(null);
    }

}
