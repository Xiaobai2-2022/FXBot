package com.fangxia.fxbot.mapper;

import com.fangxia.fxbot.dto.FXUserServerDTO;
import com.fangxia.fxbot.eo.FXServerEO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FXServerMapper extends BaseMapper<FXServerEO> {

    List<FXServerEO> selectServerByDiscordId(Long discordId);

    int insertServer(FXUserServerDTO fxOwnerServerDTO);

    int updateServer(FXUserServerDTO fxOwnerServerDTO);

    int deleteServer(FXUserServerDTO fxOwnerServerDTO);

}
