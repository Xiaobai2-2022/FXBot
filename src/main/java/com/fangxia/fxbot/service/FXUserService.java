package com.fangxia.fxbot.service;

import com.fangxia.fxbot.eo.FXUserEO;
import com.fangxia.fxbot.mapper.FXUserMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FXUserService {

    private final FXUserMapper fxUserMapper;

    public FXUserEO getUser(Long discordId) {
        return fxUserMapper.selectUserByDiscordId(discordId);
    }

    public List<FXUserEO> getAllUsers() {
        return fxUserMapper.selectList(null);
    }

    public int createUser(FXUserEO fxUserEO) {
        return fxUserMapper.insert(fxUserEO);
    }

    public int updateUser(FXUserEO fxUserEO) {
        return fxUserMapper.updateById(fxUserEO);
    }

    public int deleteUser(Long discordId) {
        return fxUserMapper.deleteByDiscordId(discordId);
    }

}
