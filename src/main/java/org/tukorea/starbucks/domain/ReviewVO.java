package org.tukorea.starbucks.domain;

import lombok.Data;

@Data
public class ReviewVO {

    private int reviewNum;

    private int userId;

    private int menuId;

    private String content;

}
