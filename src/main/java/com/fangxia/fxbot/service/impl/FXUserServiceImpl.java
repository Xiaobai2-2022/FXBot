package com.fangxia.fxbot.service.impl;

import com.fangxia.fxbot.eo.FXUserEO;
import com.fangxia.fxbot.mapper.FXUserMapper;
import com.fangxia.fxbot.service.FXIUserService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FXUserServiceImpl extends ServiceImpl<FXUserMapper, FXUserEO>
    implements FXIUserService {

    @Override
    public FXUserEO selectUserByDiscordId(Long discordId) {
        return baseMapper.selectUserByDiscordId(discordId);
    }

    @Override
    public int updateUser(FXUserEO fxUserEO) {
        return baseMapper.updateUser(fxUserEO);
    }

    @Override
    public int deleteUserByDiscordId(Long discordId) {
        return baseMapper.deleteUserByDiscordId(discordId);
    }

}
