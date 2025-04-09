package com.fangxia.fxbot.controller;

import com.fangxia.fxbot.annotations.FXValidateKey;
import com.fangxia.fxbot.common.FXApiResponse;
import com.fangxia.fxbot.dto.FXUserChannelDTO;
import com.fangxia.fxbot.eo.FXChannelEO;
import com.fangxia.fxbot.service.FXIChannelService;

import com.fangxia.fxbot.util.FXEOToVOUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor ;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/channel")
public class FXChannelController {

    private final FXIChannelService fxIChannelService;

    @GetMapping("/get/{discordId}")
    @Operation(summary = "Returns all channels owned by the given discord id")
    @FXValidateKey
    public FXApiResponse<?> getChannelByDiscordId(@PathVariable Long discordId) {
        List<FXChannelEO> fxUserChannels = fxIChannelService.getChannelByDiscordId(discordId);
        if(CollectionUtils.isEmpty(fxUserChannels)) {
            return FXApiResponse.failure(
                "Channel with discord id: " +
                discordId +
                " not found."
            );
        }
        return FXApiResponse.success(FXEOToVOUtil.toChannelVOList(fxUserChannels));
    }

    @GetMapping("/query")
    @Operation(summary = "Returns all channels")
    @FXValidateKey
    public FXApiResponse<?> getAllChannels() {
        return FXApiResponse.success(FXEOToVOUtil.toChannelVOList(fxIChannelService.list()));
    }

    @PostMapping("/create")
    @Operation(summary = "Create a new channel")
    @FXValidateKey
    public FXApiResponse<?> createChannel(@RequestBody FXUserChannelDTO fxUserChannelDTO) {
        if(fxIChannelService.createChannel(fxUserChannelDTO) > 0) {
            return FXApiResponse.success("Successfully created channel");
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
        if(fxIChannelService.updateChannel(fxUserChannelDTO) > 0) {
            return FXApiResponse.success("Successfully updated channel");
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
        if(fxIChannelService.deleteChannel(fxUserChannelDTO) > 0) {
            return FXApiResponse.success("Successfully deleted channel");
        }
        return FXApiResponse.failure(
            "Unable to delete channel with id " +
            fxUserChannelDTO.getDiscordChannelId() +
            "."
        );
    }

}
