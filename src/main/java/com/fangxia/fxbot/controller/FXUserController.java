package com.fangxia.fxbot.controller;

import com.fangxia.fxbot.annotations.FXValidateKey;
import com.fangxia.fxbot.common.FXApiResponse;
import com.fangxia.fxbot.entity.FXUserEntity;
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
        FXUserEntity fxUserEntity = fxUserService.getUser(discordId);
        if(fxUserEntity == null) {
            return FXApiResponse.failure("User with discord id: " + discordId + " not found.");
        }
        return FXApiResponse.success(fxUserEntity);
    }

    @GetMapping("/query")
    public FXApiResponse<?> getAllUsers(
        @RequestHeader(required = false) String serverKey
    ) {
        FXApiResponse<?> securityCheckDTO = fxSecurityKey.validate(serverKey);
        if(securityCheckDTO.isSuccess()) {
            return FXApiResponse.success(fxUserService.getAllUsers());
        }
        return securityCheckDTO;
    }

    @PostMapping("/create")
    public FXApiResponse<?> createUser(
        @RequestBody FXUserEntity fxUserEntity,
        @RequestHeader(required = false) String serverKey
    ) {
        FXApiResponse<?> securityCheckDTO = fxSecurityKey.validate(serverKey);
        if(securityCheckDTO.isSuccess()) {
            if(fxUserService.createUser(fxUserEntity) > 0) {
                return FXApiResponse.success(null);
            }
            return FXApiResponse.failure("Unable to create user.");
        }
        return securityCheckDTO;
    }

    @PutMapping("/update")
    @FXValidateKey
    public FXApiResponse<?> updateUser(@RequestBody FXUserEntity fxUserEntity) {
        if(fxUserService.updateUser(fxUserEntity) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure("Unable to update user");
    }

    @DeleteMapping("/delete/{id}")
    @FXValidateKey
    public FXApiResponse<?> deleteUser(@PathVariable Long id) {
        if(fxUserService.deleteUser(id) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure("Unable to delete user with id " + id + ".");
    }

}
