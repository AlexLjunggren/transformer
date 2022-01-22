package io.ljunggren.transformer.manipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DateFormatManipulationTest {

    @Test
    public void manipulateTest() {
        assertEquals("2021/05/04", new DateFormatManipulation("MM-dd-yyyy", "yyyy/MM/dd").manipulate("05-04-2021"));
        assertEquals("05-04-2021", new DateFormatManipulation(null, "yyyy/MM/dd").manipulate("05-04-2021"));
        assertEquals("05-04-2021", new DateFormatManipulation("MM-dd-yyyy", null).manipulate("05-04-2021"));
        assertEquals(null, new DateFormatManipulation("MM-dd-yyyy", "yyyy/MM/dd").manipulate(null));
        assertEquals("NotReal", new DateFormatManipulation("MM-dd-yyyy", "yyyy/MM/dd").manipulate("NotReal"));
    }
    
    @Test
    public void descriptionTest() {
        assertEquals("Transform date string from 'MM-dd-yyyy' to 'yyyy/MM/dd'", new DateFormatManipulation("MM-dd-yyyy", "yyyy/MM/dd").description());
    }

}
