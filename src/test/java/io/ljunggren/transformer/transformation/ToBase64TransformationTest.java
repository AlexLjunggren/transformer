package io.ljunggren.transformer.transformation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.ljunggren.transformer.Transformer;
import io.ljunggren.transformer.annotation.TransformToBase64;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class ToBase64TransformationTest {
    
    @AllArgsConstructor
    @Getter
    private class ToBase64Pojo {
        @TransformToBase64
        private String password;
    }

    @Test
    public void transformTest() {
        ToBase64Pojo pojo = new ToBase64Pojo("secretPassword");
        new Transformer(pojo).transform();
        assertEquals("c2VjcmV0UGFzc3dvcmQ=", pojo.getPassword());
    }

    @Test
    public void transformNullTest() {
        ToBase64Pojo pojo = new ToBase64Pojo(null);
        new Transformer(pojo).transform();
        assertEquals(null, pojo.getPassword());
    }

}
