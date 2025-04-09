package com.fangxia.fxbot.service;

import com.fangxia.fxbot.dto.FXUserChannelDTO;
import com.fangxia.fxbot.eo.FXChannelEO;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface FXIChannelService extends IService<FXChannelEO> {

    List<FXChannelEO> getChannelByDiscordId(Long discordId);

    int createChannel(FXUserChannelDTO fxUserChannelDTO);

    int updateChannel(FXUserChannelDTO fxUserChannelDTO);

    int deleteChannel(FXUserChannelDTO fxUserChannelDTO);

}
