package com.fangxia.fxbot.mapper;

import com.fangxia.fxbot.eo.FXUserEO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FXUserMapper extends BaseMapper<FXUserEO> {

    FXUserEO selectUserByDiscordId(Long discordId);

    int updateUser(FXUserEO fxUserEO);

    int deleteUserByDiscordId(Long discordId);

}
