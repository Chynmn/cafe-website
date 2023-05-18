package org.tukorea.starbucks.domain;

import lombok.Data;

@Data
public class UserVO {

    private Long num;

    private String id;

    private String passwd;

    private String userName;

    private String email;

    private Long point;

}
