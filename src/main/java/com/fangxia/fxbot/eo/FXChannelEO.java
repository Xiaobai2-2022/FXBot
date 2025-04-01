package com.fangxia.fxbot.eo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("fx_channels")
@Schema(description = "Represents a FXBot Channel")
public class FXChannelEO {

    @Schema(description = "Primary Key - Auto-Generated")
    @TableId(value = "channel_id", type = IdType.ASSIGN_UUID)
    private String channelId;

    @Schema(description = "Discord Channel Snowflake ID")
    @TableField("discord_channel_id")
    private Long discordChannelId;

    @Schema(description = "Associated User ID")
    @TableField("owner_id")
    private String ownerId;

    @Schema(description = "Associated Server ID")
    @TableField("server_id")
    private String serverId;

    @Schema(description = "Channel Display Name")
    @TableField("display_name")
    private String displayName;

    @Schema(description = "Channel Activation Status")
    @TableField("is_active")
    private Boolean isActive;

    @Schema(description = "Timestamp at creation")
    @TableField("create_time")
    private LocalDateTime createTime;

    @Schema(description = "Timestamp at last update")
    @TableField("update_time")
    private LocalDateTime updateTime;

}
