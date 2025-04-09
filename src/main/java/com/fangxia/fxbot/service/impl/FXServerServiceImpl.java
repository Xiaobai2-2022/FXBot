package com.fangxia.fxbot.service.impl;

import com.fangxia.fxbot.dto.FXUserServerDTO;
import com.fangxia.fxbot.eo.FXServerEO;
import com.fangxia.fxbot.mapper.FXServerMapper;
import com.fangxia.fxbot.service.FXIServerService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FXServerServiceImpl extends ServiceImpl<FXServerMapper, FXServerEO>
    implements FXIServerService {

    @Override
    public List<FXServerEO> getServerByDiscordId(Long discordId) {
        return baseMapper.selectServerByDiscordId(discordId);
    }

    @Override
    public int createServer(FXUserServerDTO fxUserServerDTO) {
        return baseMapper.insertServer(fxUserServerDTO);
    }

    @Override
    public int updateServer(FXUserServerDTO fxUserServerDTO) {
        return baseMapper.updateServer(fxUserServerDTO);
    }

    @Override
    public int deleteServer(FXUserServerDTO fxUserServerDTO) {
        return baseMapper.deleteServer(fxUserServerDTO);
    }

}
