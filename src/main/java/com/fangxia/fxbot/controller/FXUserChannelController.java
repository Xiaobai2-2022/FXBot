package com.fangxia.fxbot.controller;

import com.fangxia.fxbot.annotations.FXValidateKey;
import com.fangxia.fxbot.common.FXApiResponse;
import com.fangxia.fxbot.dto.FXUserChannelDTO;
import com.fangxia.fxbot.eo.FXUserChannelEO;
import com.fangxia.fxbot.service.FXUserChannelService;

import lombok.RequiredArgsConstructor ;

import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/channel")
public class FXUserChannelController {

    private final FXUserChannelService fxUserChannelService;

    @GetMapping("/get/{discordId}")
    @FXValidateKey
    public FXApiResponse<?> getChannelByDiscordId(@PathVariable Long discordId) {
        FXUserChannelEO fxUserChannelEO = fxUserChannelService.getChannel(discordId);
        if(fxUserChannelEO == null) {
            return FXApiResponse.failure(
                "Channel with discord id: " +
                discordId +
                " not found."
            );
        }
        return FXApiResponse.success(fxUserChannelEO);
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
            fxUserChannelDTO.getDiscordId() +
            ". User not registered or already in use."
        );
    }

    @PutMapping("/update")
    @FXValidateKey
    public FXApiResponse<?> updateChannel(@RequestBody FXUserChannelDTO fxUserChannelDTO) {
        if(fxUserChannelService.updateChannel(fxUserChannelDTO) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure(
            "Unable to find and update channel with discord id " +
            fxUserChannelDTO.getDiscordId() +
            "."
        );
    }

    @DeleteMapping("/delete/{discordId}")
    @FXValidateKey
    public FXApiResponse<?> deleteChannel(@PathVariable Long discordId) {
        if(fxUserChannelService.delete(discordId) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure(
            "Unable to find and delete channel with discord id " +
            discordId +
            "."
        );
    }

}
