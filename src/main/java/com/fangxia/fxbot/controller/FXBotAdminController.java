package com.fangxia.fxbot.controller;

import com.fangxia.fxbot.annotations.FXValidateKey;
import com.fangxia.fxbot.common.FXApiResponse;
import com.fangxia.fxbot.service.FXBotAdminService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class FXBotAdminController {

    private final FXBotAdminService fxBotAdminService;

    @GetMapping("/isAdmin/{discordId}")
    @Operation(summary = "Check if the given discord id is a bot admin")
    @FXValidateKey
    public FXApiResponse<?> isAdmin(@PathVariable Long discordId) {
        boolean isAdmin = fxBotAdminService.isBotAdmin(discordId);
        if (isAdmin) {
            return FXApiResponse.success("The given user is an admin");
        } else {
            return FXApiResponse.success("The given user is not an admin");
        }
    }

}
