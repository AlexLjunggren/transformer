package com.ljunggren.transformer.manipulation;

public class ReverseManipulationTest implements Manipulation<String> {
    
    @Override
    public String manipulate(String value) {
        if (value == null) {
            return null;
        }
        return new StringBuffer(value).reverse().toString();
    }

    
    @Override
    public String description() {
        return "Reverse letters";
    }
    
}
