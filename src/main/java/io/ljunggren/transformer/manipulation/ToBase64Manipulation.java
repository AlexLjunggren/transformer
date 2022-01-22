package io.ljunggren.transformer.manipulation;

import java.util.Base64;

public class ToBase64Manipulation implements Manipulation<String> {

    @Override
    public String manipulate(String value) {
        if (value == null) {
            return null;
        }
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    @Override
    public String description() {
        return "Transform to Base 64";
    }

}
