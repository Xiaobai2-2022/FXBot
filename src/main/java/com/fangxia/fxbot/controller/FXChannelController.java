package com.fangxia.fxbot.controller;

import com.fangxia.fxbot.annotations.FXValidateKey;
import com.fangxia.fxbot.common.FXApiResponse;
import com.fangxia.fxbot.dto.FXUserChannelDTO;
import com.fangxia.fxbot.eo.FXChannelEO;
import com.fangxia.fxbot.service.FXChannelService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor ;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/channel")
public class FXChannelController {

    private final FXChannelService fxChannelService;

    @GetMapping("/get/{discordId}")
    @Operation(summary = "Returns all channels owned by the given discord id")
    @FXValidateKey
    public FXApiResponse<?> getChannelByDiscordId(@PathVariable Long discordId) {
        List<FXChannelEO> fxUserChannels = fxChannelService.getChannel(discordId);
        if(fxUserChannels == null || fxUserChannels.isEmpty()) {
            return FXApiResponse.failure(
                "Channel with discord id: " +
                discordId +
                " not found."
            );
        }
        return FXApiResponse.success(fxUserChannels);
    }

    @GetMapping("/query")
    @Operation(summary = "Returns all channels")
    @FXValidateKey
    public FXApiResponse<?> getAllChannels() {
        return FXApiResponse.success(fxChannelService.getAllChannels());
    }

    @PostMapping("/create")
    @Operation(summary = "Create a new channel")
    @FXValidateKey
    public FXApiResponse<?> createChannel(@RequestBody FXUserChannelDTO fxUserChannelDTO) {
        if(fxChannelService.createChannel(fxUserChannelDTO) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure(
            "Can not create channel for: user id" +
            fxUserChannelDTO.getDiscordUserId() +
            ", server id " +
            fxUserChannelDTO.getDiscordServerId() +
            "."
        );
    }

    @PutMapping("/update")
    @Operation(summary = "Update an existing channel")
    @FXValidateKey
    public FXApiResponse<?> updateChannel(@RequestBody FXUserChannelDTO fxUserChannelDTO) {
        if(fxChannelService.updateChannel(fxUserChannelDTO) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure(
            "Unable to update channel with id " +
            fxUserChannelDTO.getDiscordChannelId() +
            "."
        );
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete an existing channel")
    @FXValidateKey
    public FXApiResponse<?> deleteChannel(@RequestBody FXUserChannelDTO fxUserChannelDTO) {
        if(fxChannelService.deleteChannel(fxUserChannelDTO) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure(
            "Unable to delete channel with id " +
            fxUserChannelDTO.getDiscordChannelId() +
            "."
        );
    }

}
