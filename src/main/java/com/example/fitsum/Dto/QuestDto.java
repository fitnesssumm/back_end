package com.example.fitsum.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class QuestDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ViewQuestDto{
        private Long questId;
        private String quest1;
        private String quest2;

    }


}
