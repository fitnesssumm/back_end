package com.example.fitsum.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;


@Slf4j
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Quest {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(example = "유저의 primary key")
    private Long questId;

    @Schema(example = "퀘스트1")
    @ColumnDefault("false")
    private String quest1;

    @Schema(example = "퀘스트2")
    @ColumnDefault("false")
    private String quest2;

    @Schema(example = "퀘스트3")
    @ColumnDefault("false")
    private String quest3;

    @ManyToOne
    @JoinColumn(name="userNo")
    @Schema(example = "연결된 유저")
    @JsonBackReference
    private User user;

}
