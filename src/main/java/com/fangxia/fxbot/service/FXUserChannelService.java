package com.fangxia.fxbot.service;

import com.fangxia.fxbot.dto.FXUserChannelDTO;
import com.fangxia.fxbot.mapper.FXUserChannelMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FXUserChannelService {

    private final FXUserChannelMapper fxUserChannelMapper;

    public int createChannel(FXUserChannelDTO fxUserChannelDTO) {
        return fxUserChannelMapper.insert(fxUserChannelDTO);
    }

    public int updateChannel(FXUserChannelDTO fxUserChannelDTO) {
        return fxUserChannelMapper.update(fxUserChannelDTO);
    }

}
