package com.ljunggren.transformer.transformation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ljunggren.transformer.Transformer;
import com.ljunggren.transformer.annotation.TransformDateFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class DateFormatTransformationTest {

    @AllArgsConstructor
    @Getter
    private class DateFormatPojo {
        @TransformDateFormat(from = "MM-dd-yyyy", to = "yyyy/MM/dd")
        private String date;
    }

    @Test
    public void transformTest() {
        DateFormatPojo pojo = new DateFormatPojo("05-04-2021");
        new Transformer(pojo).transform();
        assertEquals("2021/05/04", pojo.getDate());
    }
    
    @Test
    public void transformNullTest() {
        DateFormatPojo pojo = new DateFormatPojo(null);
        new Transformer(pojo).transform();
        assertEquals(null, pojo.getDate());
    }

}
