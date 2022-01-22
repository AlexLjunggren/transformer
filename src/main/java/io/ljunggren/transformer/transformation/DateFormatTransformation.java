package io.ljunggren.transformer.transformation;

import java.lang.annotation.Annotation;

import io.ljunggren.transformer.Item;
import io.ljunggren.transformer.annotation.TransformDateFormat;
import io.ljunggren.transformer.manipulation.DateFormatManipulation;
import io.ljunggren.transformer.manipulation.Manipulation;

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
