package com.example.fitsum.service;


import com.example.fitsum.Dto.QuestDto;
import com.example.fitsum.Dto.QuestDtoConverter;
import com.example.fitsum.domain.Quest;
import com.example.fitsum.model_response.repository.QuestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Service
public class QuestService {

    private final QuestRepository questRepository;

    @Transactional
    public List<QuestDto.ViewQuestDto> getQusetList(){

        List<Quest> questList = questRepository.findByQuesttitle();

        List<QuestDto.ViewQuestDto> viewQuestList = new ArrayList<>();

        for (Quest quest : questList){
            viewQuestList.add(QuestDtoConverter.toViewQuestDto(quest));
        }
        return viewQuestList;
    }


}
