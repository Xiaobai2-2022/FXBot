package com.fangxia.fxbot.controller;

import com.fangxia.fxbot.annotations.FXValidateKey;
import com.fangxia.fxbot.common.FXApiResponse;
import com.fangxia.fxbot.eo.FXUserEO;
import com.fangxia.fxbot.security.FXSecurityKey;
import com.fangxia.fxbot.service.FXUserService;

import lombok.RequiredArgsConstructor ;

import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class FXUserController {

    private final FXUserService fxUserService;

    private final FXSecurityKey fxSecurityKey;

    @GetMapping("/get/{discordId}")
    @FXValidateKey
    public FXApiResponse<?> getUserByDiscordId(@PathVariable Long discordId) {
        FXUserEO fxUserEO = fxUserService.getUser(discordId);
        if(fxUserEO == null) {
            return FXApiResponse.failure("User with discord id: " + discordId + " not found.");
        }
        return FXApiResponse.success(fxUserEO);
    }

    @GetMapping("/query")
    @FXValidateKey
    public FXApiResponse<?> getAllUsers() {
        return FXApiResponse.success(fxUserService.getAllUsers());
    }

    @PostMapping("/create")
    @FXValidateKey
    public FXApiResponse<?> createUser(@RequestBody FXUserEO fxUserEO) {
        if(fxUserService.createUser(fxUserEO) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure("Unable to create user.");
    }

    @PutMapping("/update")
    @FXValidateKey
    public FXApiResponse<?> updateUser(@RequestBody FXUserEO fxUserEO) {
        if(fxUserService.updateUser(fxUserEO) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure("Unable to update user");
    }

    @DeleteMapping("/delete/{discordId}")
    @FXValidateKey
    public FXApiResponse<?> deleteUser(@PathVariable Long discordId) {
        if(fxUserService.deleteUser(discordId) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure("Unable to delete user with discord id " + discordId + ".");
    }

}
