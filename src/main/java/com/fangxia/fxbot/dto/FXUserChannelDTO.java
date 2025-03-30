package com.fangxia.fxbot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "A DTO transfer user and channel information")
public class FXUserChannelDTO {

    @Schema(description = "Discord User Snowflake ID")
    private Long discordUserId;

    @Schema(description = "Discord Channel Snowflake ID")
    private Long discordChannelId;

    @Schema(description = "Channel Display Name")
    private String channelDisplayName;

}
