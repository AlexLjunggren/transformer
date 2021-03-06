package io.ljunggren.transformer.transformation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.ljunggren.transformer.Transformer;
import io.ljunggren.transformer.annotation.CustomTransformer;
import io.ljunggren.transformer.manipulation.ToBase64Manipulation;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class CustomTransmformationTest {
    
    @AllArgsConstructor
    @Getter
    private class CustomPojo {
        @CustomTransformer(ToBase64Manipulation.class)
        private String password;
    }

    @Test
    public void transformTest() {
        CustomPojo pojo = new CustomPojo("secret");
        new Transformer(pojo).transform();
        assertEquals("c2VjcmV0", pojo.getPassword());
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
