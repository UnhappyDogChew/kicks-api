package com.kicks.api.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoeOverviewDto {

    private String name;
    private ProductTag tag;
    private float price;
    private String imageUrl;
}
