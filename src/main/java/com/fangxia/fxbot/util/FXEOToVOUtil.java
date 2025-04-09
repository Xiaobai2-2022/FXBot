package com.fangxia.fxbot.util;

import com.fangxia.fxbot.eo.FXServerEO;
import com.fangxia.fxbot.eo.FXUserEO;
import com.fangxia.fxbot.vo.FXServerVO;
import com.fangxia.fxbot.vo.FXUserVO;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FXEOToVOUtil {

    public static FXUserVO toVO(FXUserEO fxUserEO) {
        if (fxUserEO == null) {
            return null;
        }
        return FXUserVO.builder()
                .userId(fxUserEO.getUserId())
                .discordId(fxUserEO.getDiscordId())
                .displayName(fxUserEO.getDisplayName())
                .build();
    }

    public static FXServerVO toVO(FXServerEO fxServerEO) {
        if (fxServerEO == null) {
            return null;
        }
        return FXServerVO.builder()
                .serverId(fxServerEO.getServerId())
                .discordServerId(fxServerEO.getDiscordServerId())
                .ownerId(fxServerEO.getOwnerId())
                .displayName(fxServerEO.getDisplayName())
                .build();
    }

    public static List<FXUserVO> toUserVOList(List<FXUserEO> fxUserEOList) {
        if (CollectionUtils.isEmpty(fxUserEOList)) {
            return List.of();
        }
        return fxUserEOList.stream()
                .filter(Objects::nonNull)
                .map(FXEOToVOUtil::toVO)
                .collect(Collectors.toList());
    }

    public static List<FXServerVO> toServerVOList(List<FXServerEO> fxServerEOList) {
        if (CollectionUtils.isEmpty(fxServerEOList)) {
            return List.of();
        }
        return fxServerEOList.stream()
                .filter(Objects::nonNull)
                .map(FXEOToVOUtil::toVO)
                .collect(Collectors.toList());
    }

}
