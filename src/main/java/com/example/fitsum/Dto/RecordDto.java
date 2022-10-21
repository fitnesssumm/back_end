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
    public static class CreatePushupDto {
        private User user;
        private Long recordId;
        private LocalDate recordDate;
        private String pushup;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateSquartDto {
        private User user;
        private Long recordId;
        private LocalDate recordDate;
        private String squart;
    }


}
