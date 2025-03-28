package com.fangxia.fxbot.controller;

import com.fangxia.fxbot.annotations.FXValidateKey;
import com.fangxia.fxbot.common.FXApiResponse;
import com.fangxia.fxbot.dto.FXUserChannelDTO;
import com.fangxia.fxbot.service.FXUserChannelService;

import lombok.RequiredArgsConstructor ;

import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/channel")
public class FXUserChannelController {

    private final FXUserChannelService fxUserChannelService;

    @PostMapping("/create")
    @FXValidateKey
    public FXApiResponse<?> createChannel(@RequestBody FXUserChannelDTO fxUserChannelDTO) {
        if(fxUserChannelService.createChannel(fxUserChannelDTO) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure("Unable to create channel.");
    }

    @PutMapping("/update")
    @FXValidateKey
    public FXApiResponse<?> updateChannel(@RequestBody FXUserChannelDTO fxUserChannelDTO) {
        if(fxUserChannelService.updateChannel(fxUserChannelDTO) > 0) {
            return FXApiResponse.success(null);
        }
        return FXApiResponse.failure("Unable to create channel.");
    }

}
