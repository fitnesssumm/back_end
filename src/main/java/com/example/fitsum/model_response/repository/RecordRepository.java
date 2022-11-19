package com.example.fitsum.model_response.repository;

import com.example.fitsum.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecordRepository extends JpaRepository<Record, Long> {

    public Optional<Record> findByRecordId(Long recordId);
    public Optional<Record> findByPushup(Long pushup);
    public Optional<Record> findBySquart(Long squart);

}
