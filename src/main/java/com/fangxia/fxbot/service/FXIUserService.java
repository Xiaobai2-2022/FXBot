package com.fangxia.fxbot.service;

import com.fangxia.fxbot.eo.FXUserEO;

import com.baomidou.mybatisplus.extension.service.IService;

public interface FXIUserService extends IService<FXUserEO> {

    FXUserEO selectUserByDiscordId(Long discordId);

    int updateUser(FXUserEO fxUserEO);

    int deleteUserByDiscordId(Long discordId);

}
