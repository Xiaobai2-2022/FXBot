package com.fangxia.fxbot.service;

import com.fangxia.fxbot.entity.FXUserEntity;
import com.fangxia.fxbot.mapper.FXUserMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FXUserService {

    private final FXUserMapper fxUserMapper;

    public FXUserEntity getUser(Long discordId) {
        return fxUserMapper.selectUserByDiscordId(discordId);
    }

    public List<FXUserEntity> getAllUsers() {
        return fxUserMapper.selectList(null);
    }

    public int createUser(FXUserEntity fxUserEntity) {
        return fxUserMapper.insert(fxUserEntity);
    }

    public int updateUser(FXUserEntity fxUserEntity) {
        return fxUserMapper.updateById(fxUserEntity);
    }

    public int deleteUser(Long discordId) {
        return fxUserMapper.deleteByDiscordId(discordId);
    }

}
