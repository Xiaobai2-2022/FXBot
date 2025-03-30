package com.fangxia.fxbot.service;

import com.fangxia.fxbot.dto.FXUserChannelDTO;
import com.fangxia.fxbot.eo.FXUserChannelEO;
import com.fangxia.fxbot.mapper.FXUserChannelMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FXUserChannelService {

    private final FXUserChannelMapper fxUserChannelMapper;

    public FXUserChannelEO getChannel(Long discordId) {
        return fxUserChannelMapper.selectChannelByDiscordId(discordId);
    }

    public List<FXUserChannelEO> getAllChannels() {
        return fxUserChannelMapper.selectList(null);
    }

    public int createChannel(FXUserChannelDTO fxUserChannelDTO) {
        return fxUserChannelMapper.insert(fxUserChannelDTO);
    }

    public int updateChannel(FXUserChannelDTO fxUserChannelDTO) {
        return fxUserChannelMapper.updateByDiscordId(fxUserChannelDTO);
    }

    public int delete(Long discordId) {
        return fxUserChannelMapper.deleteByDiscordId(discordId);
    }

}
