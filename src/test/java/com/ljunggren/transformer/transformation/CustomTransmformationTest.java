package com.ljunggren.transformer.transformation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ljunggren.transformer.Transformer;
import com.ljunggren.transformer.annotation.CustomTransformer;
import com.ljunggren.transformer.manipulation.ReverseManipulationTest;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class CustomTransmformationTest {
    
    @AllArgsConstructor
    @Getter
    private class CustomPojo {
        @CustomTransformer(ReverseManipulationTest.class)
        private String password;
    }

    @Test
    public void transformTest() {
        CustomPojo pojo = new CustomPojo("secret");
        new Transformer(pojo).transform();
        assertEquals("terces", pojo.getPassword());
    }
    
    @AllArgsConstructor
    @Getter
    private class NonManipulationPojo {
        @CustomTransformer(String.class)
        private String password;
    }
    
    @Test
    public void transformInvalidClassTest() {
        NonManipulationPojo pojo = new NonManipulationPojo("secret");
        new Transformer(pojo).transform();
        assertEquals("secret", pojo.getPassword());
    }

}
