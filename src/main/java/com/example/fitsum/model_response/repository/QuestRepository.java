package com.example.fitsum.model_response.repository;

import com.example.fitsum.domain.Quest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestRepository extends JpaRepository<Quest, Long> {
     @Query(value = "SELECT * FROM Quest order by RAND() limit 2",
             nativeQuery = true)
     List<Quest> findByQuesttitle();
    }
