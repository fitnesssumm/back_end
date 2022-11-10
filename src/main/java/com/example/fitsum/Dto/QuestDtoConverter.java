package com.example.fitsum.Dto;

import com.example.fitsum.domain.Quest;
import org.springframework.stereotype.Component;

@Component
public class QuestDtoConverter {

    public static QuestDto.ViewQuestDto toViewQuestDto(Quest quest){
        return QuestDto.ViewQuestDto.builder()
                .questTitle(quest.getQuestTitle())
                .questSuccess(quest.getQuestSuccess())
                .build();
    }
}
