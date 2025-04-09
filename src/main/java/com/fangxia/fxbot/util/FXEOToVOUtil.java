package com.fangxia.fxbot.util;

import com.fangxia.fxbot.eo.FXUserEO;
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

    public static List<FXUserVO> toVOList(List<FXUserEO> fxUserEOList) {
        if (CollectionUtils.isEmpty(fxUserEOList)) {
            return List.of();
        }
        return fxUserEOList.stream()
                .filter(Objects::nonNull)
                .map(FXEOToVOUtil::toVO)
                .collect(Collectors.toList());
    }

}
