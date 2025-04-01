package com.fangxia.fxbot.service;

import com.fangxia.fxbot.dto.FXUserServerDTO;
import com.fangxia.fxbot.eo.FXServerEO;
import com.fangxia.fxbot.mapper.FXServerMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FXServerService {

    private final FXServerMapper fxServerMapper;

    public List<FXServerEO> getServer(Long discordId) {
        return fxServerMapper.selectServerByDiscordId(discordId);
    }

    public List<FXServerEO> getAllServers() {
        return fxServerMapper.selectList(null);
    }

    public int createServer(FXUserServerDTO fxUserServerDTO) {
        return fxServerMapper.insertServer(fxUserServerDTO);
    }

    public int updateServer(FXUserServerDTO fxUserServerDTO) {
        return fxServerMapper.updateServer(fxUserServerDTO);
    }

    public int deleteServer(FXUserServerDTO fxUserServerDTO) {
        return fxServerMapper.deleteServer(fxUserServerDTO);
    }

}
