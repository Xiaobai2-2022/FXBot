package com.fangxia.fxbot.mapper;

import com.fangxia.fxbot.dto.FXUserChannelDTO;
import com.fangxia.fxbot.eo.FXChannelEO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FXChannelMapper extends BaseMapper<FXChannelEO> {

    List<FXChannelEO> selectChannelByDiscordId(Long discordId);

    int insertChannel(FXUserChannelDTO fxUserChannelDTO);

    int updateChannel(FXUserChannelDTO fxUserChannelDTO);

    int deleteChannel(FXUserChannelDTO fxUserChannelDTO);

}
