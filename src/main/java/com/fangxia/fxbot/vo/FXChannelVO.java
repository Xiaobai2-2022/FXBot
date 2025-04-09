package com.fangxia.fxbot.vo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FXChannelVO {

    private String channelId;

    private Long discordChannelId;

    private String ownerId;

    private String serverId;

    private String displayName;

}
