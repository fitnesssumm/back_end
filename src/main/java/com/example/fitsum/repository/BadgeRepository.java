package com.example.fitsum.repository;

import com.example.fitsum.domain.Badge;
import com.example.fitsum.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BadgeRepository extends JpaRepository<Badge, Long> {

    public Optional<Badge> findByBadgeId(Long badgeId);

    public Optional<Badge> findByBadge1(User user);

    public Optional<List<Badge>> findByUser(User user);

//    public Optional<List<Badge>> findAll();




}