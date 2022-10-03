package com.example.fitsum.Dto;

import lombok.Getter;


public class DailyquestDto {

    @Getter
    public static class DailyquestviewDto{

        private Long dailyquestNO;
        private String quest_title;
        private int Success;
    }

    @Getter
    public static class QuestSuccess{
        private String quest_title;
        private int Success;


    }
}
