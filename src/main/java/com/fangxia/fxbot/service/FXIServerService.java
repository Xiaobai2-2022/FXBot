package com.fangxia.fxbot.service;

import com.fangxia.fxbot.dto.FXUserServerDTO;
import com.fangxia.fxbot.eo.FXServerEO;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface FXIServerService extends IService<FXServerEO> {

    List<FXServerEO> getServerByDiscordId(Long discordId);

    int createServer(FXUserServerDTO fxUserServerDTO);

    int updateServer(FXUserServerDTO fxUserServerDTO);

    int deleteServer(FXUserServerDTO fxUserServerDTO);

}
