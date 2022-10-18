package com.example.fitsum.Dto;

import com.example.fitsum.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BadgeDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class RepBadgeDto {

        private Long badgeId;
        private User user;

        private String badgetitle;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class BadgeViewDto {
        private Long badgeId;
        private String badgetitle;
        private String userId;
        private User user;
        private Boolean opens;
        private Boolean isMe;

    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CollectBadgeDto {
        private String badgetitle;
        private User user;
        private Boolean opens;

    }


}
