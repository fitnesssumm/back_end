package com.example.fitsum.repository;

import com.example.fitsum.domain.User;
import com.example.fitsum.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BadgeRepository extends JpaRepository<Badge, Long> {

    public Optional<Badge> findByBadgeId(Long badgeId);

    public Optional<Badge> findByBadgetitle(String badgetitle);


    public boolean existsByBadgetitle(String badgetitle);



}
