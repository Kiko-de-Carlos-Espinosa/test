package com.kiko_de_carlos.Test.dto;

import javax.validation.constraints.NotBlank;

public class Product {

    @NotBlank
    private String id;
    @NotBlank
    private String name;
    private Number price;
    private boolean availability;

}
