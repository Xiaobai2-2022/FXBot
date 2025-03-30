package com.fangxia.fxbot.service;

import com.fangxia.fxbot.dto.FXUserChannelDTO;
import com.fangxia.fxbot.eo.FXChannelEO;
import com.fangxia.fxbot.mapper.FXChannelMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FXChannelService {

    private final FXChannelMapper fxUserChannelMapper;

    public List<FXChannelEO> getChannel(Long discordId) {
        return fxUserChannelMapper.selectChannelByDiscordId(discordId);
    }

    public List<FXChannelEO> getAllChannels() {
        return fxUserChannelMapper.selectList(null);
    }

    public int createChannel(FXUserChannelDTO fxUserChannelDTO) {
        return fxUserChannelMapper.insertChannel(fxUserChannelDTO);
    }

    public int updateChannel(FXUserChannelDTO fxUserChannelDTO) {
        return fxUserChannelMapper.updateChannel(fxUserChannelDTO);
    }

    public int delete(FXUserChannelDTO fxUserChannelDTO) {
        return fxUserChannelMapper.deleteChannel(fxUserChannelDTO);
    }

}
