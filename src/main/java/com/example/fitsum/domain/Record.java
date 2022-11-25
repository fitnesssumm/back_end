package com.example.fitsum.domain;

import com.example.fitsum.exception.exceptions.CAuthenticationException;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.time.LocalDate;

@Slf4j
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

public class Record {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(example = "유저의 primary key")
    private Long recordId;

    @Column
    @Schema(example = "상체운동 기록")
    private String pushup;

    @Column
    @Schema(example = "하체운동 기록")
    private String squart;

    @ManyToOne
    @JoinColumn(name = "user_no")
    @Schema(example = "연결된 유저")
    @JsonBackReference
    private User user;

    @Schema(example = "기록 일자")
    private LocalDate recordDate;



}
