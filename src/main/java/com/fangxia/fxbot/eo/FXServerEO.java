package com.fangxia.fxbot.eo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("fx_servers")
@Schema(description = "Represents a FXBot Server")
public class FXServerEO {

    @Schema(description = "Primary Key - Auto-Generated")
    @TableId(value = "server_id", type = IdType.ASSIGN_UUID)
    private String serverId;

    @Schema(description = "Discord Server Snowflake ID")
    @TableField("discord_server_id")
    private Long discordServerId;

    @Schema(description = "Associated User ID")
    @TableField("owner_id")
    private String ownerId;

    @Schema(description = "Server Display Name")
    @TableField("display_name")
    private String displayName;

    @Schema(description = "Timestamp at creation")
    @TableField("create_time")
    private LocalDateTime createTime;

    @Schema(description = "Timestamp at last update")
    @TableField("update_time")
    private LocalDateTime updateTime;

}
