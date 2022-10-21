package com.example.fitsum.repository;

import com.example.fitsum.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BadgeRepository extends JpaRepository<Badge, Long> {

    public Optional<Badge> findByBadgeId(Long badgeId);



}