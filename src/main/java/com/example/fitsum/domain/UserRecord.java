package com.example.fitsum.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public class UserRecord {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true)
        @Schema(example = "유저와 기록의 다대 다 관계에 대한 primary key")
        private Long userRecordId;

        @ManyToOne
        @JoinColumn(name = "user_no")
        @Schema(example = "유저 다대 일 관계")
        private User user;

        @ManyToOne
        @JoinColumn(name = "recordId")
        @Schema(example = "기록 다대 일 관계")
        private Record record;


}

