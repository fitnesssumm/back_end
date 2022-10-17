package com.example.fitsum.domain;

import com.example.fitsum.exception.exceptions.CAuthenticationException;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.List;

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


    @Schema(example = "뱃지제목")
    private String badgetitle;


    @Schema(example = "회득 여부")
    @ColumnDefault("false")
    private Boolean opens;

    @ManyToOne
    @JoinColumn(name="userNo")
    private User user;

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