package com.heidsoft.model;

import lombok.Data;

/**
 * @program: heidsoft-mybatis
 * @description: 国家
 * @author: heidsoft
 * @create: 2018-11-17 13:41
 **/
@Data
public class Country {
    private int id;

    private String countryName;

    private String countryCode;
}
