package com.fangxia.fxbot.mapper;

import com.fangxia.fxbot.dto.FXUserChannelDTO;
import com.fangxia.fxbot.eo.FXUserChannelEO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FXUserChannelMapper extends BaseMapper<FXUserChannelEO> {

    FXUserChannelEO selectChannelByDiscordId(Long discordId);

    int insert(FXUserChannelDTO fxUserChannelDTO);

    int updateByDiscordId(FXUserChannelDTO fxUserChannelDTO);

    int deleteByDiscordId(Long discordId);

}
