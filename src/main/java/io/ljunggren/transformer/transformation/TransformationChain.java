package io.ljunggren.transformer.transformation;

import java.lang.annotation.Annotation;

import io.ljunggren.transformer.Item;

public abstract class TransformationChain {

    protected TransformationChain nextChain;
    
    public TransformationChain nextChain(TransformationChain nextChain) {
        this.nextChain = nextChain;
        return this;
    }
    
    public abstract void transform(Annotation annotation, Item item);
    
    protected boolean isString(Item item) {
        return item.getValue() instanceof String;
    }
    
}
