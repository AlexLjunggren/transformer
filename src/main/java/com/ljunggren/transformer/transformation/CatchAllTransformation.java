package com.ljunggren.transformer.transformation;

import java.lang.annotation.Annotation;

import com.ljunggren.transformer.Item;

public class CatchAllTransformation extends TransformationChain {

    @Override
    public void transform(Annotation annotation, Item item) {
        return;
    }

}
