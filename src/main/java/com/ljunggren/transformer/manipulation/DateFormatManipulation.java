package com.ljunggren.transformer.manipulation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatManipulation implements Manipulation<String> {
    
    private String from;
    private String to;

    public DateFormatManipulation(String from, String to) {
        this.from = from;
        this.to = to;
    }
    
    @Override
    public String manipulate(String value) {
        if (value == null || from == null || to == null) {
            return value;
        }
        try {
            Date date = simpleDateFormat(from).parse(value);
            return simpleDateFormat(to).format(date);
        } catch (ParseException e) {
            return value;
        }
    }
    
    private SimpleDateFormat simpleDateFormat(String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    @Override
    public String description() {
        return String.format("Transform date string from '%s' to '%s'", from, to);
    }

}
