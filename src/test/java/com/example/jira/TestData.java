package com.example.jira;

import com.example.jira.model.*;

import java.util.*;

public class TestData {

    public static final String ID_1 = "id_1";
    public static final String SELF_1 = "self_1";
    public static final String KEY_1 = "key_1";
    public static final String EXPAND_1 = "expand_1";
    public static final String ID_2 = "id_2";
    public static final String SELF_2 = "self_2";
    public static final String KEY_2 = "key_2";
    public static final String EXPAND_2 = "expand_2";

    public static List<TShirtSize> getTShirtSizes() {
        return List.of(TShirtSize.builder()
                        .id(1)
                        .sizeName(TShirtSizeName.XS)
                        .sizeValue(0.3)
                        .build(),
                TShirtSize.builder()
                        .id(2)
                        .sizeName(TShirtSizeName.S)
                        .sizeValue(0.6)
                        .build(),
                TShirtSize.builder()
                        .id(3)
                        .sizeName(TShirtSizeName.M)
                        .sizeValue(1)
                        .build(),
                TShirtSize.builder()
                        .id(4)
                        .sizeName(TShirtSizeName.L)
                        .sizeValue(1.5)
                        .build(),
                TShirtSize.builder()
                        .id(5)
                        .sizeName(TShirtSizeName.XL)
                        .sizeValue(2)
                        .build());
    }
}
