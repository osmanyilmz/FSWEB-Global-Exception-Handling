package com.workintech.zoo.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Koala {
    private Integer id;
    private String name;
    private Double sleepHour;
    private Double weight;
    private String gender;
}
