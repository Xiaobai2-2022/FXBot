package com.fangxia.fxbot.service.impl;

import com.fangxia.fxbot.dto.FXUserChannelDTO;
import com.fangxia.fxbot.eo.FXChannelEO;
import com.fangxia.fxbot.mapper.FXChannelMapper;
import com.fangxia.fxbot.service.FXIChannelService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FXChannelServiceImpl extends ServiceImpl<FXChannelMapper, FXChannelEO>
    implements FXIChannelService {

    @Override
    public List<FXChannelEO> getChannelByDiscordId(Long discordId) {
        return baseMapper.selectChannelByDiscordId(discordId);
    }

    @Override
    public int createChannel(FXUserChannelDTO fxUserChannelDTO) {
        return baseMapper.insertChannel(fxUserChannelDTO);
    }

    @Override
    public int updateChannel(FXUserChannelDTO fxUserChannelDTO) {
        return baseMapper.updateChannel(fxUserChannelDTO);
    }

    @Override
    public int deleteChannel(FXUserChannelDTO fxUserChannelDTO) {
        return baseMapper.deleteChannel(fxUserChannelDTO);
    }

}
