package com.fangxia.fxbot.controller;

import com.fangxia.fxbot.annotations.FXValidateKey;
import com.fangxia.fxbot.common.FXApiResponse;
import com.fangxia.fxbot.dto.FXUserServerDTO;
import com.fangxia.fxbot.eo.FXServerEO;
import com.fangxia.fxbot.service.FXIServerService;

import com.fangxia.fxbot.util.FXEOToVOUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/server")
public class FXServerController {

    private final FXIServerService fxIServerService;

    @GetMapping("/get/{discordId}")
    @Operation(summary = "Returns all servers owned by the given discord id")
    @FXValidateKey
    public FXApiResponse<?> getServerByDiscordId(@PathVariable Long discordId) {
        List<FXServerEO> fxUserServers = fxIServerService.getServerByDiscordId(discordId);
        if(CollectionUtils.isEmpty(fxUserServers)) {
            return FXApiResponse.failure(
                "Server with discord id: " +
                discordId +
                " not found."
            );
        }
        return FXApiResponse.success(FXEOToVOUtil.toServerVOList(fxUserServers));
    }

    @GetMapping("/query")
    @Operation(summary = "Returns all servers")
    @FXValidateKey
    public FXApiResponse<?> getAllServers() {
        return FXApiResponse.success(FXEOToVOUtil.toServerVOList(fxIServerService.list()));
    }

    @PostMapping("/create")
    @Operation(summary = "Create a new server")
    @FXValidateKey
    public FXApiResponse<?> createServer(@RequestBody FXUserServerDTO fxUserServerDTO) {
        if(fxIServerService.createServer(fxUserServerDTO) > 0) {
            return FXApiResponse.success("Server successfully created.");
        }
        return FXApiResponse.failure(
            "Can not create server for: " +
            fxUserServerDTO.getDiscordUserId() +
            ". User not registered."
        );

    }

    @PutMapping("/update")
    @Operation(summary = "Update an existing server")
    @FXValidateKey
    public FXApiResponse<?> updateServer(@RequestBody FXUserServerDTO fxUserServerDTO) {
        if(fxIServerService.updateServer(fxUserServerDTO) > 0) {
            return FXApiResponse.success("Server successfully updated.");
        }
        return FXApiResponse.failure(
            "Unable to update server with id " +
            fxUserServerDTO.getDiscordServerId() +
            "."
        );
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete an existing server")
    @FXValidateKey
    public FXApiResponse<?> deleteServer(@RequestBody FXUserServerDTO fxUserServerDTO) {
        if(fxIServerService.deleteServer(fxUserServerDTO) > 0) {
            return FXApiResponse.success("Server successfully deleted.");
        }
        return FXApiResponse.failure(
            "Unable to delete server with id " +
            fxUserServerDTO.getDiscordServerId() +
            "."
        );
    }

}
