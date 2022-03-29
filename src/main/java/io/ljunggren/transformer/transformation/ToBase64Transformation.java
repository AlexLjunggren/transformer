package io.ljunggren.transformer.transformation;

import java.lang.annotation.Annotation;

import io.ljunggren.transformer.Item;
import io.ljunggren.transformer.annotation.TransformToBase64;
import io.ljunggren.transformer.manipulation.Manipulation;
import io.ljunggren.transformer.manipulation.ToBase64Manipulation;

public class ToBase64Transformation extends TransformationChain {

    @Override
    public void transform(Annotation annotation, Item item) {
        if (annotation.annotationType() == TransformToBase64.class && isString(item)) {
            Manipulation<String> manipulation = new ToBase64Manipulation();
            item.setValue(manipulation.manipulate(item.getValue().toString()));
        }
        nextChain.transform(annotation, item);
    }

}
