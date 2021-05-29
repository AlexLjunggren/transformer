package com.ljunggren.transformer.manipulation;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToBase64ManipulationTest {

    @Test
    public void manipulationTest() {
        assertEquals("c2VjcmV0UGFzc3dvcmQ=", new ToBase64Manipulation().manipulate("secretPassword"));
        assertEquals("", new ToBase64Manipulation().manipulate(""));
        assertEquals(null, new ToBase64Manipulation().manipulate(null));
    }
    
    @Test
    public void descriptionTest() {
        assertEquals("Transform to Base 64", new ToBase64Manipulation().description());
    }

}
