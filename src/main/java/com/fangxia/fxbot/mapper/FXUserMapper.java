package com.fangxia.fxbot.mapper;

import com.fangxia.fxbot.entity.FXUserEntity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FXUserMapper extends BaseMapper<FXUserEntity> {
}
