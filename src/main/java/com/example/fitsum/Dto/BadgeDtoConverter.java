package com.example.fitsum.Dto;

import com.example.fitsum.domain.Badge;
import org.springframework.stereotype.Component;

@Component
public class BadgeDtoConverter {
    public static BadgeDto.BadgeViewDto toBadgeViewDto(Badge badge, Boolean isMe) {
        return BadgeDto.BadgeViewDto.builder()
                .badgeId(badge.getBadgeId())
                .badgetitle(badge.getBadgetitle())
                .opens(badge.getOpens())
                .isMe(isMe)
                .build();
    }
}