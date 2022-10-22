package com.example.fitsum.Dto;

import com.example.fitsum.domain.Badge;
import org.springframework.stereotype.Component;

@Component
public class BadgeDtoConverter {
    public static BadgeDto.ViewBadge toViewBadgeDto(Badge badge) {
        return BadgeDto.ViewBadge.builder()
                .badgeId(badge.getBadgeId())
                .user(badge.getUser())
                .badge1(badge.getBadge1())
                .build();
    }
}
