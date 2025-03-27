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

    public FXUserEntity getUserById(Long userId) {
        return fxUserMapper.selectById(userId);
    }

    public List<FXUserEntity> getAllUsers() {
        return fxUserMapper.selectList(null);
    }

    public void createUser(FXUserEntity fxUserEntity) {
        fxUserMapper.insert(fxUserEntity);
    }

    public void updateUser(FXUserEntity fxUserEntity) {
        fxUserMapper.updateById(fxUserEntity);
    }

    public void deleteUser(Long userId) {
        fxUserMapper.deleteById(userId);
    }

}
