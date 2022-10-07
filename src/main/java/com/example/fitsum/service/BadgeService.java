package com.example.fitsum.service;

import com.example.fitsum.Dto.BadgeDto;
import com.example.fitsum.Dto.BadgeDtoConverter;
import com.example.fitsum.domain.Badge;
import com.example.fitsum.domain.User;
import com.example.fitsum.exception.exceptions.CDiaryListNotFoundException;
import com.example.fitsum.exception.exceptions.CUserNotFoundException;
import com.example.fitsum.repository.BadgeRepository;
import com.example.fitsum.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Slf4j
@RestController
@RequiredArgsConstructor
@Service
public class BadgeService {

     final private BadgeRepository badgeRepository;

     final private UserRepository userRepository;

     final private BadgeDtoConverter badgeDtoConverter;


    @Transactional
    public BadgeDto.BadgeViewDto getBadgeByBadgeId(Long badgeId) {
        //다이어리 엔티티 가져오기
        Badge badge = badgeRepository.findByBadgeId(badgeId).orElseThrow(CDiaryListNotFoundException::new);
        return badgeDtoConverter.toBadgeViewDto(badge, badge.checkUser(true));
    }

    @Transactional
    public void collectBadge(String userId, BadgeDto.CollectBadgeDto collectBadgeDto) {

        //일기장 db에 저장할 유저를 가져옵니다.
        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);

        //일기장에 저장합니다.
        Badge badge = badgeRepository.save(
                Badge.builder()
                        .user(user)
                        .badgetitle(collectBadgeDto.getBadgetitle())
                        .success(collectBadgeDto.getSuccess())
                        .build()
        );
    }
}