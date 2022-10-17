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

    @Column(unique = true)
    @Schema(example = "상체운동 기록")
    private Long pushuprecord;

    @Column(unique = true)
    @Schema(example = "하체운동 기록")
    private Long squartrecord;

    @ManyToOne
    @JoinColumn(name = "user_no")
    @Schema(example = "연결된 유저")
    @JsonBackReference
    private User user;

    @Schema(example = "기록 일자")
    private LocalDate recordDate;

    public boolean checkUser(boolean isMe){
        String userId;
        //권한을 통해 유저 id를 획득합니다.
        try {
            //권한을 통해 유저 id를 획득합니다.
            userId = SecurityContextHolder.getContext().getAuthentication().getName();
        }catch(NullPointerException e){
            log.info("정상적으로 로그인 되지 않았습니다.");
            throw new CAuthenticationException();
        }
        if(!this.getUser().getUserId().equals(userId)) {
            log.info("로그인한 유저와 일기의 유저가 다릅니다.");
            isMe = false;
        }
        return isMe;
    }

}
