package io.ljunggren.transformer.transformation;

import java.lang.annotation.Annotation;

import io.ljunggren.transformer.Item;

public class CatchAllTransformation extends TransformationChain {

    @Override
    public void transform(Annotation annotation, Item item) {
        return;
    }

}
