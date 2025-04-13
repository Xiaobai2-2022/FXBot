package com.fangxia.fxbot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FXBotAdminMapper {

    boolean isBotAdmin(@Param("discordUserId") Long discordUserId);

}
