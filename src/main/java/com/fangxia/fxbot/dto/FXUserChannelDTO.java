package com.fangxia.fxbot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "A DTO transfer user and channel information")
public class FXUserChannelDTO {

    @Schema(description = "FXBot UUID")
    private String userId;

    @Schema(description = "Discord Snowflake ID")
    private Long discordId;

    @Schema(description = "FXBot Channel UUID")
    private String channelId;

    @Schema(description = "User Display Name")
    private String userDisplayName;

    @Schema(description = "Channel Display Name")
    private String channelDisplayName;

}
