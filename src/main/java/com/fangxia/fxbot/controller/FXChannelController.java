package com.fangxia.fxbot.controller;

import com.fangxia.fxbot.annotations.FXValidateKey;
import com.fangxia.fxbot.common.FXApiResponse;
import com.fangxia.fxbot.dto.FXUserChannelDTO;
import com.fangxia.fxbot.eo.FXChannelEO;
import com.fangxia.fxbot.service.FXChannelService;

import lombok.RequiredArgsConstructor ;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/channel")
public class FXChannelController {

    private final FXChannelService fxUserChannelService;

    @GetMapping("/get/{discordId}")
    @FXValidateKey
    public FXApiResponse<?> getChannelByDiscordId(@PathVariable Long discordId) {
        List<FXChannelEO> fxUserChannelEOs = fxUserChannelService.getChannel(discordId);
        if(fxUserChannelEOs == null || fxUserChannelEOs.isEmpty()) {
            return FXApiResponse.failure(
                "Channel with discord id: " +
                discordId +
                " not found."
            );
        }
        return FXApiResponse.success(fxUserChannelEOs);
    }

    @GetMapping("/query")
    @FXValidateKey
    public FXApiResponse<?> getAllChannels() {
        return FXApiResponse.success(fxUserChannelService.getAllChannels());
    }

    @PostMapping("/create")
    @FXValidateKey
    public FXApiResponse<?> createChannel(@RequestBody FXUserChannelDTO fxUserChannelDTO) {
        if(fxUserChannelService.createChannel(fxUserChannelDTO) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure(
            "Can not create channel for: " +
            fxUserChannelDTO.getDiscordUserId() +
            ". User not registered."
        );
    }

    @PutMapping("/update")
    @FXValidateKey
    public FXApiResponse<?> updateChannel(@RequestBody FXUserChannelDTO fxUserChannelDTO) {
        if(fxUserChannelService.updateChannel(fxUserChannelDTO) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure(
            "Unable to find and update channel with id " +
            fxUserChannelDTO.getDiscordChannelId() +
            "."
        );
    }

    @DeleteMapping("/delete")
    @FXValidateKey
    public FXApiResponse<?> deleteChannel(@RequestBody FXUserChannelDTO fxUserChannelDTO) {
        if(fxUserChannelService.delete(fxUserChannelDTO) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure(
            "Unable to find and delete channel with id " +
            fxUserChannelDTO.getDiscordChannelId() +
            "."
        );
    }

}
