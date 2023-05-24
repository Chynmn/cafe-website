package org.tukorea.starbucks.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MenuVO {
    private int id;

    private String menuName;

    private String content;

    private String nutritionInformation;

    private int kcal;

    private int saturatedFat;

    private int protein;

    private int natrium;

    private int sugars;

    private int caffeine;

    private String allergy;

    private MultipartFile imageFile;

    private String image;
}
