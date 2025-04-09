package com.fangxia.fxbot.vo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FXServerVO {

    private String serverId;

    private Long discordServerId;

    private String ownerId;

    private String displayName;

}
