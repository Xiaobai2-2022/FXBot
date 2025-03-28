package com.fangxia.fxbot.eo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("fx_user_channels")
@Schema(description = "Represents a FXBot Channel")
public class FXUserChannelEO {

    @Schema(description = "Primary Key - Auto-Generated")
    @TableId(value = "channel_id", type = IdType.AUTO)
    private Long channelId;

    @Schema(description = "Associated User ID")
    @TableField("user_id")
    private Long userId;

    @Schema(description = "Channel Display Name")
    @TableField("display_name")
    private String displayName;

    @Schema(description = "Timestamp at creation")
    @TableField("create_time")
    private LocalDateTime createTime;

    @Schema(description = "Timestamp at last update")
    @TableField("update_time")
    private LocalDateTime updateTime;

}
