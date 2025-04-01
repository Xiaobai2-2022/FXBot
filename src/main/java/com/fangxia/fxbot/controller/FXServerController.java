package com.fangxia.fxbot.controller;

import com.fangxia.fxbot.annotations.FXValidateKey;
import com.fangxia.fxbot.common.FXApiResponse;
import com.fangxia.fxbot.dto.FXUserServerDTO;
import com.fangxia.fxbot.eo.FXServerEO;
import com.fangxia.fxbot.service.FXServerService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/server")
public class FXServerController {

    private final FXServerService fxServerService;

    @GetMapping("/get/{discordId}")
    @FXValidateKey
    public FXApiResponse<?> getServerByDiscordId(@PathVariable Long discordId) {
        List<FXServerEO> fxUserServers = fxServerService.getServer(discordId);
        if(fxUserServers == null || fxUserServers.isEmpty()) {
            return FXApiResponse.failure(
                "Server with discord id: " +
                discordId +
                " not found."
            );
        }
        return FXApiResponse.success(fxUserServers);
    }

    @GetMapping("/query")
    @FXValidateKey
    public FXApiResponse<?> getAllServers() {
        return FXApiResponse.success(fxServerService.getAllServers());
    }

    @PostMapping("/create")
    @FXValidateKey
    public FXApiResponse<?> createServer(@RequestBody FXUserServerDTO fxUserServerDTO) {
        if(fxServerService.createServer(fxUserServerDTO) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure(
            "Can not create server for: " +
            fxUserServerDTO.getDiscordUserId() +
            ". User not registered."
        );

    }

    @PutMapping("/update")
    @FXValidateKey
    public FXApiResponse<?> updateServer(@RequestBody FXUserServerDTO fxUserServerDTO) {
        if(fxServerService.updateServer(fxUserServerDTO) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure(
            "Unable to update server with id " +
                fxUserServerDTO.getDiscordServerId() +
            "."
        );
    }

    @DeleteMapping("/delete")
    @FXValidateKey
    public FXApiResponse<?> deleteServer(@RequestBody FXUserServerDTO fxUserServerDTO) {
        if(fxServerService.deleteServer(fxUserServerDTO) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure(
            "Unable to delete server with id " +
            fxUserServerDTO.getDiscordServerId() +
            "."
        );
    }

}
