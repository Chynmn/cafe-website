package org.tukorea.starbucks.domain;

import lombok.Data;

@Data
public class MemberVO {

    private String id;

    private String passwd;

    private String user_name;

    private String email;

    private String phone_num;

}
