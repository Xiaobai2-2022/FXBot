package com.fangxia.fxbot.controller;

import com.fangxia.fxbot.annotations.FXValidateKey;
import com.fangxia.fxbot.common.FXApiResponse;
import com.fangxia.fxbot.eo.FXUserEO;
import com.fangxia.fxbot.service.FXIUserService;

import com.fangxia.fxbot.util.FXEOToVOUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor ;

import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class FXUserController {

    private final FXIUserService fxIUserService;

    @GetMapping("/get/{discordId}")
    @Operation(summary = "Returns the user with the given discord id")
    @FXValidateKey
    public FXApiResponse<?> getUserByDiscordId(@PathVariable Long discordId) {
        FXUserEO fxUserEO = fxIUserService.selectUserByDiscordId(discordId);
        if(fxUserEO == null) {
            return FXApiResponse.failure("User with discord id: " + discordId + " not found.");
        }
        return FXApiResponse.success(FXEOToVOUtil.toVO(fxUserEO));
    }

    @GetMapping("/query")
    @Operation(summary = "Returns all users")
    @FXValidateKey
    public FXApiResponse<?> getAllUsers() {
        return FXApiResponse.success(FXEOToVOUtil.toUserVOList(fxIUserService.list()));
    }

    @PostMapping("/create")
    @Operation(summary = "Create a new user")
    @FXValidateKey
    public FXApiResponse<?> createUser(@RequestBody FXUserEO fxUserEO) {
        fxIUserService.save(fxUserEO);
        return FXApiResponse.success("User has been created.");
    }

    @PutMapping("/update")
    @Operation(summary = "Update an existing user")
    @FXValidateKey
    public FXApiResponse<?> updateUser(@RequestBody FXUserEO fxUserEO) {
        if(fxIUserService.updateUser(fxUserEO) > 0) {
            return FXApiResponse.success("User has been updated.");
        }
        return FXApiResponse.failure("Unable to find user with discord id " + fxUserEO.getDiscordId() + ".");
    }

    @DeleteMapping("/delete/{discordId}")
    @Operation(summary = "Delete an existing user")
    @FXValidateKey
    public FXApiResponse<?> deleteUser(@PathVariable Long discordId) {
        if(fxIUserService.deleteUserByDiscordId(discordId) > 0) {
            return FXApiResponse.success("User has been deleted.");
        }
        return FXApiResponse.failure("Unable to find user with discord id " + discordId + ".");
    }

}
