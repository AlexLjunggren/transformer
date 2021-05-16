package com.ljunggren.transformer.transformation;

import java.lang.annotation.Annotation;

import com.ljunggren.transformer.Item;
import com.ljunggren.transformer.annotation.TransformDateFormat;
import com.ljunggren.transformer.manipulation.DateFormatManipulation;
import com.ljunggren.transformer.manipulation.Manipulation;

public class DateFormatTransformation extends TransformationChain {

    @Override
    public void transform(Annotation annotation, Item item) {
        if (annotation.annotationType() == TransformDateFormat.class && item.getValue() instanceof String) {
            TransformDateFormat dateFormat = ((TransformDateFormat) annotation);
            Manipulation<String> manipulation = new DateFormatManipulation(dateFormat.from(), dateFormat.to());
            item.setValue(manipulation.manipulate(item.getValue().toString()));
        }
        nextChain.transform(annotation, item);
    }

}
