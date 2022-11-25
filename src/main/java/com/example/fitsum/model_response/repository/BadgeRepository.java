package com.example.fitsum.model_response.repository;

import com.example.fitsum.domain.Badge;
import com.example.fitsum.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BadgeRepository extends JpaRepository<Badge, Long> {

    public Optional<List<Badge>> findByUser(User user);

    public boolean existsByUser(User user);





}