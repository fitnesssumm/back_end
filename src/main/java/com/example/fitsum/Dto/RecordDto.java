package com.example.fitsum.Dto;

import com.example.fitsum.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class RecordDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class RepRecordDto {
        private User user;
        private Long recordId;
        private LocalDate recordDate;
        private Long pushuprecord;
        private Long squartrecord;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateRecordDto {
        private User user;
        private Long recordId;
        private LocalDate recordDate;
        private Long pushuprecord;
        private Long squartrecord;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class RecordViewDto {
        private String userId;
        private Long recordId;
        private LocalDate recordDate;
        private Long pushuprecord;
        private Long squartrecord;

        private String storedFilePath;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ShowRecordDto {
        private String userId;
        private Long recordID;
        private LocalDate recordDate;
        private Long pushuprecord;
        private Long squartrecord;

        private Boolean isMe;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SendRecordDto {
        private Long pushuprecord;
        private Long squartrecord;
    }
}
