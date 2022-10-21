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
public class UserBadge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    @Schema(example = "유저와 뱃지의 다대 다 관계에 대한 primary key")
    private Long userBadgeId;

    @ManyToOne
    @JoinColumn(name = "user_no")
    @Schema(example = "유저 다대 일 관계")
    private User user;

    @ManyToOne
    @JoinColumn(name = "badge_id")
    @Schema(example = "뱃지 다대 일 관계")
    private Badge badge;
}