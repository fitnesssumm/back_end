package com.example.fitsum.service;

import com.example.fitsum.Dto.BadgeDto;
import com.example.fitsum.Dto.BadgeDtoConverter;
import com.example.fitsum.domain.Badge;
import com.example.fitsum.exception.exceptions.*;
import com.example.fitsum.repository.BadgeRepository;
import com.example.fitsum.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

import static java.util.regex.Pattern.matches;

@Slf4j
@RestController
@RequiredArgsConstructor
@Service
public class BadgeService {

    final private BadgeRepository badgeRepository;
    final private BadgeDtoConverter badgeDtoConverter;

    @Transactional
    public void successBadge(BadgeDto.CollectBadgeDto collectBadgeDto){
        Badge badge = Badge.builder()
                .user(collectBadgeDto.getUser())
                .badgetitle(collectBadgeDto.getBadgetitle())
                .opens(collectBadgeDto.getOpens())
                .build();

        badgeRepository.save(badge);
    }

    @Transactional
    public void checkBadge(String badgetitle) {
        //뱃지가 존재하면 생성 불가
        if (badgeRepository.existsByBadgetitle(badgetitle))
            throw new CUserIdAlreadyExistsException();
    }


    @Transactional
    public BadgeDto.BadgeViewDto getBadgeBybadgeId(Long badgeId){
        Badge badge = badgeRepository.findByBadgeId(badgeId).orElseThrow(CBoardNotFoundException::new);

        return badgeDtoConverter.toBadgeViewDto(badge, badge.checkUser(true));
    }


}