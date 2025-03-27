package com.fangxia.fxbot.controller;

import com.fangxia.fxbot.common.FXApiResponse;
import com.fangxia.fxbot.dto.FXUserChannelDTO;
import com.fangxia.fxbot.security.FXSecurityKey;
import com.fangxia.fxbot.service.FXUserChannelService;

import lombok.RequiredArgsConstructor ;

import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/channel")
public class FXUserChannelController {

    private final FXUserChannelService fxUserChannelService;
    private final FXSecurityKey fxSecurityKey;

    @PostMapping("/create")
    public FXApiResponse<?> createChannel(
        @RequestBody FXUserChannelDTO fxUserChannelDTO,
        @RequestHeader(required = false) String serverKey
    ) {
        FXApiResponse<?> securityCheckDTO = fxSecurityKey.validate(serverKey);
        if(securityCheckDTO.isSuccess()) {
            if(fxUserChannelService.createChannel(fxUserChannelDTO) > 0) {
                return FXApiResponse.success(null);
            }
            return FXApiResponse.failure("Unable to create channel.");
        }
        return securityCheckDTO;
    }

    @PutMapping("/update")
    public FXApiResponse<?> updateChannel(
            @RequestBody FXUserChannelDTO fxUserChannelDTO,
            @RequestHeader(required = false) String serverKey
    ) {
        FXApiResponse<?> securityCheckDTO = fxSecurityKey.validate(serverKey);
        if(securityCheckDTO.isSuccess()) {
            if(fxUserChannelService.updateChannel(fxUserChannelDTO) > 0) {
                return FXApiResponse.success(null);
            }
            return FXApiResponse.failure("Unable to create channel.");
        }
        return securityCheckDTO;
    }

}
