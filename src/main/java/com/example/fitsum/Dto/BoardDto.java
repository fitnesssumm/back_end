package com.example.fitsum.Dto;

import com.example.fitsum.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class BoardDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateBoardDto {
        private String title;
        private String content;
        private LocalDate writeDate;

    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class BoardViewDto {

        private Long boardId;
        private String userId;
        private String loginId;
        private String nickName;
        private String content;
        private String title;
        private String writeDate;

        private String storedFilePath;
    }


    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ShowBoardDto {
        private Long boardId;

        private String userId;
        // private String title;
        private String content;
        private Boolean open;
        private LocalDate writeDate;

        private Boolean isMe;

        private Integer likeNum;
    }

//    @Getter
//    @Builder
//    @AllArgsConstructor
//    public static class BoardResultDto {
//        private Long boardId;
//
//        private String userId;
//
//        // private String title;
//        private String content;
//        private Boolean open;
//        private Integer likeNum;
//        private LocalDate writeDate;
//
//    }

//    @Getter
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public static class UpdateBoardDto {
//        private String content;
//    }

//    @Getter
//    @Builder
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public static class SendContentDto {
//        private String content;
//    }

    //    @Getter
//    @AllArgsConstructor
//    @NoArgsConstructor
//    @Builder
//    public static class RepBoardDto {
//        private Long boardId;
//        private User user;
//
//        private String content;
//        private Boolean open;
//        private Integer likeNum;
//        private LocalDate writeDate;
//
//    }

}
