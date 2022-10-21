package com.example.fitsum.service;

import com.example.fitsum.Dto.BadgeDto;
import com.example.fitsum.domain.Badge;
import com.example.fitsum.domain.User;
import com.example.fitsum.exception.exceptions.CUserNotFoundException;
import com.example.fitsum.repository.BadgeRepository;
import com.example.fitsum.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@Slf4j
@RestController
@RequiredArgsConstructor
@Service
public class BadgeService {

    private final BadgeRepository badgeRepository;

    private final UserRepository userRepository;


    @Transactional
    public void createBadge(String userId, BadgeDto.CreateBadgeDto createBadgeDto) {

        //일기장 db에 저장할 유저를 가져옵니다.
        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);

        //일기장에 저장합니다.
        Badge badge = badgeRepository.save(
                Badge.builder()
                        .user(user)
                        .badge1(createBadgeDto.getBadge1())
                        .badge2(createBadgeDto.getBadge2())
                        .badge3(createBadgeDto.getBadge3())
                        .badge4(createBadgeDto.getBadge4())
                        .badge5(createBadgeDto.getBadge5())
                        .badge6(createBadgeDto.getBadge6())
                        .build()
        );
    }
}