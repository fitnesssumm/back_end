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
public class Badge {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(example = "유저의 primary key")
    private Long badgeId;




    @Schema(example = "뱃지1")
    @ColumnDefault("false")
    private Boolean badge1;

    @Schema(example = "뱃지2")
    @ColumnDefault("false")
    private Boolean badge2;

    @Schema(example = "뱃지3")
    @ColumnDefault("false")
    private Boolean badge3;

    @Schema(example = "뱃지4")
    @ColumnDefault("false")
    private Boolean badge4;

    @Schema(example = "뱃지5")
    @ColumnDefault("false")
    private Boolean badge5;

    @Schema(example = "뱃지6")
    @ColumnDefault("false")
    private Boolean badge6;

    @ManyToOne
    @JoinColumn(name="userNo")
    @Schema(example = "연결된 유저")
    @JsonBackReference
    private User user;


}
