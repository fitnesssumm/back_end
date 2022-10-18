package com.example.fitsum.service;

import com.example.fitsum.Dto.RecordDto;
import com.example.fitsum.Dto.RecordDtoConverter;
import com.example.fitsum.domain.Board;
import com.example.fitsum.domain.Record;
import com.example.fitsum.domain.User;
import com.example.fitsum.exception.exceptions.CBoardNotFoundException;
import com.example.fitsum.exception.exceptions.CUserNotFoundException;
import com.example.fitsum.repository.RecordRepository;
import com.example.fitsum.repository.UserBoardRepository;
import com.example.fitsum.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Slf4j
@RequiredArgsConstructor
@Service
public class RecordService {
    final private RecordRepository recordRepository;

    final private UserRepository userRepository;

    final private RecordDtoConverter recordDtoConverter;

    private final UserBoardRepository userBoardRepository;

    private RestTemplate restTemplate;

    @Transactional
    public RecordDto.ShowRecordDto getRecordByRecordId(Long recordId) {
        //다이어리 엔티티 가져오기
        Record record = recordRepository.findByRecordId(recordId).orElseThrow(CBoardNotFoundException::new);

        //checkUser에서 본인인지 아닌지를 판별합니다. 본인일 경우 편집 버튼을 활성화 해서 updateBoard로 이동이 가능해집니다.
        return recordDtoConverter.toShowRecordDto(record, record.checkUser(true));
    }

    @Transactional
    public void saveRecord(String userId, RecordDto.CreateRecordDto createRecordDto) {

        //일기장 db에 저장할 유저를 가져옵니다.
        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);

        //일기장에 저장합니다.
        Record record = recordRepository.save(
                Record.builder()
                        .user(user)
                        .pushuprecord(createRecordDto.getPushuprecord())
                        .squartrecord(createRecordDto.getSquartrecord())
                        .recordDate(LocalDate.now())
                        .build()
        );
    }
}
