package org.tukorea.starbucks.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MenuVO {
    private int id;

    private String menu_name;

    private String publisher;

    private String content;

    private String nutrition_info;

    private int kcal;

    private int saturated_fat;

    private int protein;

    private int natrium;

    private int sugars;

    private int caffeine;

    private MultipartFile imageFile;

    private String image;
}
