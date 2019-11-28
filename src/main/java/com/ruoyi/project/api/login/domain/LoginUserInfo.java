package com.ruoyi.project.api.login.domain;

import lombok.Data;

@Data
public class LoginUserInfo {

    private String nickName;
    private String avatarUrl;
    private String gender;
    private String city;
    private String country;
    private String province;
    private String code;
}
