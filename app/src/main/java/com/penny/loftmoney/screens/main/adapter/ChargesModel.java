package com.penny.loftmoney.screens.main.adapter;

import java.io.Serializable;

public class ChargesModel implements Serializable {

    public static String KEY_NAME = "charges_model";

    private String name;
    private String value;

    public ChargesModel(String name, String value) {
        this.name = name;
        this.value = value;
    }

    String getName() {
        return name;
    }

    String getValue() {
        return value;
    }
}
