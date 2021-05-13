package com.ljunggren.transformer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ljunggren.transformer.annotation.DateFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class TransformerTest {

    @AllArgsConstructor
    @Getter
    private class TestPojo {
        @DateFormat(from = "MM-dd-yyyy", to = "yyyy/MM/dd")
        private String date;
    }

    @Test
    public void transformTest() {
        TestPojo pojo = new TestPojo("05-04-2021");
        new Transformer(pojo).transform();
        assertEquals("2021/05/04", pojo.getDate());
    }

}
