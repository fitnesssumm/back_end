package com.example.fitsum.model_response.repository;

import com.example.fitsum.domain.User;
import com.example.fitsum.domain.UserBadge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserBadgeRepository extends JpaRepository<UserBadge, Long> {

    public Optional<List<UserBadge>> findAllByUser(User user);


}
