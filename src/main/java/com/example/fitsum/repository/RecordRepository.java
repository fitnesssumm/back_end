package com.example.fitsum.repository;

import com.example.fitsum.domain.Badge;
import com.example.fitsum.domain.Record;
import com.example.fitsum.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecordRepository extends JpaRepository<Record, Long> {

    public Optional<Record> findByRecordId(Long recordId);
    public Optional<Record> findByPushup(Long pushup);
    public Optional<Record> findBySquart(Long squart);

}
