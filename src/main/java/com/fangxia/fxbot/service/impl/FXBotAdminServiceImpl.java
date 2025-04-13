package com.fangxia.fxbot.service.impl;

import com.fangxia.fxbot.mapper.FXBotAdminMapper;
import com.fangxia.fxbot.service.FXBotAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FXBotAdminServiceImpl
    implements FXBotAdminService {

    private final FXBotAdminMapper fxBotAdminMapper;

    public boolean isBotAdmin(Long discordId) {
        return fxBotAdminMapper.isBotAdmin(discordId);
    }

}
