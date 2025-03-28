package com.fangxia.fxbot.eo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("fx_users")
@Schema(description = "Represents a FXBot User")
public class FXUserEO {

    @Schema(description = "Primary Key - Auto-Generated")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    @Schema(description = "Discord Snowflake ID")
    @TableField("discord_id")
    private Long discordId;

    @Schema(description = "User Display Name")
    @TableField("display_name")
    private String displayName;

    @Schema(description = "Timestamp at creation")
    @TableField("create_time")
    private LocalDateTime createTime;

    @Schema(description = "Timestamp at last update")
    @TableField("update_time")
    private LocalDateTime updateTime;
    
}
