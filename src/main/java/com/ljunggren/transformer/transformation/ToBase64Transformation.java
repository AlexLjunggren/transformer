package com.ljunggren.transformer.transformation;

import java.lang.annotation.Annotation;

import com.ljunggren.transformer.Item;
import com.ljunggren.transformer.annotation.TransformToBase64;
import com.ljunggren.transformer.manipulation.Manipulation;
import com.ljunggren.transformer.manipulation.ToBase64Manipulation;

public class ToBase64Transformation extends TransformationChain {

    @Override
    public void transform(Annotation annotation, Item item) {
        if (annotation.annotationType() == TransformToBase64.class && item.getValue() instanceof String) {
            Manipulation<String> manipulation = new ToBase64Manipulation();
            item.setValue(manipulation.manipulate(item.getValue().toString()));
        }
        nextChain.transform(annotation, item);
    }

}
