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
        private int userSex;

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
}
