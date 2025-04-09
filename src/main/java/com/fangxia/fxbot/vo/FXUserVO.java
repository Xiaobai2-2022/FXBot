package com.fangxia.fxbot.vo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FXUserVO {

    private String userId;

    private Long discordId;

    private String displayName;

}
