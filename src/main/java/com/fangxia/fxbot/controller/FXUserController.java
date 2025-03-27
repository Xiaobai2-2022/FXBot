package com.fangxia.fxbot.controller;

import com.fangxia.fxbot.common.FXApiResponse;
import com.fangxia.fxbot.entity.FXUserEntity;
import com.fangxia.fxbot.security.FXSecurityKey;
import com.fangxia.fxbot.service.FXUserService;

import lombok.RequiredArgsConstructor ;

import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class FXUserController {

    private final FXUserService fxUserService;

    private final FXSecurityKey fxSecurityKey;

    @GetMapping("/get/{id}")
    public FXApiResponse<?> getUserById(
        @PathVariable Long id,
        @RequestHeader(required = false) String serverKey
        ) {
        FXApiResponse<?> securityCheckDTO = fxSecurityKey.validate(serverKey);
        if(securityCheckDTO.isSuccess()) {
            return FXApiResponse.success(fxUserService.getUserById(id));
        }
        return securityCheckDTO;
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
    public FXApiResponse<?> updateUser(
        @RequestBody FXUserEntity fxUserEntity,
        @RequestHeader(required = false) String serverKey
    ) {
        FXApiResponse<?> securityCheckDTO = fxSecurityKey.validate(serverKey);
        if(securityCheckDTO.isSuccess()) {
            if(fxUserService.updateUser(fxUserEntity) > 0) {
                return FXApiResponse.success(null);
            }
            return FXApiResponse.failure("Unable to update user");
        }
        return securityCheckDTO;
    }

    @DeleteMapping("/delete/{id}")
    public FXApiResponse<?> deleteUser(
        @PathVariable Long id,
        @RequestHeader(required = false) String serverKey
    ) {
        FXApiResponse<?> securityCheckDTO = fxSecurityKey.validate(serverKey);
        if(securityCheckDTO.isSuccess()) {
            if(fxUserService.deleteUser(id) > 0) {
                return FXApiResponse.success(null);
            }
            return FXApiResponse.failure("Unable to delete user with id " + id + ".");
        }
        return securityCheckDTO;
    }

}
