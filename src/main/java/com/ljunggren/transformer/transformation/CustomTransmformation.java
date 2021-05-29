package com.ljunggren.transformer.transformation;

import java.lang.annotation.Annotation;

import com.ljunggren.transformer.Item;
import com.ljunggren.transformer.annotation.CustomTransformer;
import com.ljunggren.transformer.manipulation.Manipulation;

public class CustomTransmformation extends TransformationChain {

    @Override
    public void transform(Annotation annotation, Item item) {
        if (annotation.annotationType() == CustomTransformer.class) {
            Class<?> clazz = ((CustomTransformer) annotation).value();
            try {
                Manipulation<Object> manipulation = instantiateManipulation(clazz);
                item.setValue(manipulation.manipulate(item.getValue()));
            } catch (Exception e) {
                // do something with exception
            }
        }
        nextChain.transform(annotation, item);
    }
    
    @SuppressWarnings("unchecked")
    private Manipulation<Object> instantiateManipulation(Class<?> clazz) throws Exception {
        try {
            if (Manipulation.class.isAssignableFrom(clazz)) {
                return (Manipulation<Object>) clazz.newInstance();
            }
            throw new Exception(String.format("CustomeTransformer(%s) does not implement Manipulation", clazz.getSimpleName()));
        } catch (ClassNotFoundException e) {
            throw new Exception("CustomValidator class not found " + e.getMessage());
        }
    }

}
