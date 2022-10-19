package com.example.fitsum.Dto;

import lombok.Getter;


public class UserDto {


    @Getter
    public static class SignUpUserDto {

        private String userId;
        private String userPw;
        private String nickName;
        private String userName;
        private String email;
        private Integer userSex;
        private Integer userCoin;
        private Integer userItem;

    }
    @Getter
    public static class FindPwDto{
        private String userId;
        private String email;
        private String userName;
    }

    @Getter
    public static class ChangePwDto {

        private String curPw;
        private String newPw;

    }

    @Getter
    public static class ChangenickNameDto {

        private String curnickName;
        private String newnickName;

    }

    @Getter
    public static class ChangeUserItemDto {

        private Integer curUserItem;
        private Integer newUserItem;

    }

    @Getter
    public static class ChangeUserCoinDto {

        private Integer curUserCoin;
        private Integer newUserCoin;

    }
}
