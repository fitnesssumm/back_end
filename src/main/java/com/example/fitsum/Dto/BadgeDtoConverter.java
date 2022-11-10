package com.example.fitsum.Dto;

import com.example.fitsum.domain.Badge;
import org.springframework.stereotype.Component;

@Component
public class BadgeDtoConverter {
    public static BadgeDto.ViewBadge toViewBadgeDto(Badge badge, String loginId) {
        return BadgeDto.ViewBadge.builder()
                .badgeId(badge.getBadgeId())
                .badge1(badge.getBadge1())
                .badge2(badge.getBadge2())
                .badge3(badge.getBadge3())
                .badge4(badge.getBadge4())
                .badge5(badge.getBadge5())
                .badge6(badge.getBadge6())
                .userId(badge.getUser().getUserId())
                .loginId(loginId)


                .build();
    }
}
