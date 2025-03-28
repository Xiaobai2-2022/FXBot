package com.fangxia.fxbot.mapper;

import com.fangxia.fxbot.entity.FXUserEntity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FXUserMapper extends BaseMapper<FXUserEntity> {

    FXUserEntity selectUserByDiscordId(Long discordId);

    int deleteByDiscordId(Long discordId);

}
