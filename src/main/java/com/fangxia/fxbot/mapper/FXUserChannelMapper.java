package com.fangxia.fxbot.mapper;

import com.fangxia.fxbot.dto.FXUserChannelDTO;
import com.fangxia.fxbot.entity.FXUserChannelEntity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FXUserChannelMapper extends BaseMapper<FXUserChannelEntity> {

    int insert(FXUserChannelDTO fxUserChannelDTO);

    int update(FXUserChannelDTO fxUserChannelDTO);

}
