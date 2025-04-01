package com.fangxia.fxbot.controller;

import com.fangxia.fxbot.annotations.FXValidateKey;
import com.fangxia.fxbot.common.FXApiResponse;
import com.fangxia.fxbot.eo.FXUserEO;
import com.fangxia.fxbot.security.FXSecurityKey;
import com.fangxia.fxbot.service.FXUserService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor ;

import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class FXUserController {

    private final FXUserService fxUserService;

    private final FXSecurityKey fxSecurityKey;

    @GetMapping("/get/{discordId}")
    @Operation(summary = "Returns the user with the given discord id")
    @FXValidateKey
    public FXApiResponse<?> getUserByDiscordId(@PathVariable Long discordId) {
        FXUserEO fxUserEO = fxUserService.getUser(discordId);
        if(fxUserEO == null) {
            return FXApiResponse.failure("User with discord id: " + discordId + " not found.");
        }
        return FXApiResponse.success(fxUserEO);
    }

    @GetMapping("/query")
    @Operation(summary = "Returns all users")
    @FXValidateKey
    public FXApiResponse<?> getAllUsers() {
        return FXApiResponse.success(fxUserService.getAllUsers());
    }

    @PostMapping("/create")
    @Operation(summary = "Create a new user")
    @FXValidateKey
    public FXApiResponse<?> createUser(@RequestBody FXUserEO fxUserEO) {
        fxUserService.createUser(fxUserEO);
        return FXApiResponse.success(null);
    }

    @PutMapping("/update")
    @Operation(summary = "Update an existing user")
    @FXValidateKey
    public FXApiResponse<?> updateUser(@RequestBody FXUserEO fxUserEO) {
        if(fxUserService.updateUser(fxUserEO) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure("Unable to find user with discord id " + fxUserEO.getDiscordId() + ".");
    }

    @DeleteMapping("/delete/{discordId}")
    @Operation(summary = "Delete an existing user")
    @FXValidateKey
    public FXApiResponse<?> deleteUser(@PathVariable Long discordId) {
        if(fxUserService.deleteUser(discordId) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure("Unable to find user with discord id " + discordId + ".");
    }

}
