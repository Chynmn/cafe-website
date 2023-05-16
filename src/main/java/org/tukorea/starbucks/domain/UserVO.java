package org.tukorea.starbucks.domain;

import lombok.Data;

import java.util.Date;

@Data
public class UserVO {
    private int num;
    private String id;
    private String passwd;
    private String userName;
    private String email;
    private int point;
    private Date createdAt;
    private Date updatedAt;
}
