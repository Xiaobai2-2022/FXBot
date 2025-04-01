package com.fangxia.fxbot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "A DTO transfer user and server information")
public class FXUserServerDTO {

    @Schema(description = "Discord Snowflake ID")
    private Long discordUserId;

    @Schema(description = "FXBot Server UUID")
    private String discordServerId;

    @Schema(description = "Server Display Name")
    private String serverDisplayName;

}
