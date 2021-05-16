package com.ljunggren.transformer.transformation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ljunggren.transformer.Transformer;
import com.ljunggren.transformer.annotation.TransformDateFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class CatchAllTransformationTest {

    @AllArgsConstructor
    @Getter
    private class Pojo {
        @TransformDateFormat(from = "", to = "")
        private int number;
    }

    @Test
    public void transformTest() {
        Pojo pojo = new Pojo(1234);
        new Transformer(pojo).transform();
        assertEquals(1234, pojo.getNumber());
    }

}
