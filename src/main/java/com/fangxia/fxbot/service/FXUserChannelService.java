package com.fangxia.fxbot.service;

import com.fangxia.fxbot.dto.FXUserChannelDTO;
import com.fangxia.fxbot.entity.FXUserChannelEntity;
import com.fangxia.fxbot.mapper.FXUserChannelMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FXUserChannelService {

    private final FXUserChannelMapper fxUserChannelMapper;

    public FXUserChannelEntity getChannel(Long discordId) {
        return fxUserChannelMapper.selectByDiscordId(discordId);
    }

    public List<FXUserChannelEntity> getAllChannels() {
        return fxUserChannelMapper.selectList(null);
    }

    public int createChannel(FXUserChannelDTO fxUserChannelDTO) {
        return fxUserChannelMapper.insert(fxUserChannelDTO);
    }

    public int updateChannel(FXUserChannelDTO fxUserChannelDTO) {
        return fxUserChannelMapper.update(fxUserChannelDTO);
    }

}
