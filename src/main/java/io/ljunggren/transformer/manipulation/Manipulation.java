package io.ljunggren.transformer.manipulation;

public interface Manipulation<T> {

    String manipulate(T value);
    String description();
    
}
