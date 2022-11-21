package com.example.fitsum.service;

import com.example.fitsum.Dto.BadgeDto;
import com.example.fitsum.Dto.BadgeDtoConverter;
import com.example.fitsum.domain.Badge;
import com.example.fitsum.domain.User;
import com.example.fitsum.exception.exceptions.CUserNotFoundException;
import com.example.fitsum.model_response.repository.BadgeRepository;
import com.example.fitsum.model_response.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateBadgeGetService {

    private final UserRepository userRepository;

    private final BadgeRepository badgeRepository;


    @Transactional
    public List<BadgeDto.ViewBadge> UpdateBadge2(Boolean curBadge2, Boolean newBadge2){

        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);
        List<Badge> badgeList = badgeRepository.findByUser(user).orElseThrow();
        List<BadgeDto.ViewBadge> viewBadge = new ArrayList<>();
        for (Badge badge : badgeList) {
            viewBadge.add(BadgeDtoConverter.toViewBadgeDto(badge, userId));
            badge.setBadge2(newBadge2);

        }
        return viewBadge;
    }


    @Transactional
    public List<BadgeDto.ViewBadge> UpdateBadge3(Boolean curBadge3, Boolean newBadge3){

        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);
        List<Badge> badgeList = badgeRepository.findByUser(user).orElseThrow();
        List<BadgeDto.ViewBadge> viewBadge = new ArrayList<>();
        for (Badge badge : badgeList) {
            viewBadge.add(BadgeDtoConverter.toViewBadgeDto(badge, userId));
            badge.setBadge3(newBadge3);

        }
        return viewBadge;
    }

}
