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
    public static class CreateBadgeDto {
        private User user;
        private Boolean badge1;
        private Boolean badge2;
        private Boolean badge3;
        private Boolean badge4;
        private Boolean badge5;
        private Boolean badge6;

    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ViewBadge {
        private Long badgeId;
        private Boolean badge1;
        private Boolean badge2;
        private Boolean badge3;
        private Boolean badge4;
        private Boolean badge5;
        private Boolean badge6;
        private String userId;
        private String loginId;

    }

    @Getter
    public static class ChangeBadge2 {
        private Boolean curBadge2;
        private Boolean newBadge2;
    }
    @Getter
    public static class ChangeBadge3 {
        private Boolean curBadge3;
        private Boolean newBadge3;
    }

}

