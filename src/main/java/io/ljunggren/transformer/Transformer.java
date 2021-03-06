package io.ljunggren.transformer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.reflect.FieldUtils;

import io.ljunggren.transformer.transformation.CatchAllTransformation;
import io.ljunggren.transformer.transformation.CustomTransmformation;
import io.ljunggren.transformer.transformation.DateFormatTransformation;
import io.ljunggren.transformer.transformation.ToBase64Transformation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Transformer {

    private Object object;

    public Transformer transform() {
        List<Item> items = findItems(object);
        transformItems(items);
        return this;
    }
    
    private List<Item> findItems(Object object) {
        List<Item> items = new ArrayList<Item>();
        List<Field> fields = findObjectFields(object);
        for (Field field : fields) {
            try {
                Object value = FieldUtils.readField(field, object, true);
                items.add(new Item(object, field, value));
            } catch (IllegalAccessException e) {
                // TODO: Add something here
            }
        }
        return items;
    }
    
    private List<Field> findObjectFields(Object object) {
        if (object != null) {
            Class<?> clazz = object.getClass();
            return FieldUtils.getAllFieldsList(clazz);
        }
        return new ArrayList<Field>();
    }
    
    private void transformItems(List<Item> items) {
        items.stream().forEach(item -> transformItem(item));
    }
    
    private void transformItem(Item item) {
        Annotation[] annotations = item.getField().getAnnotations();
        Arrays.asList(annotations).forEach(annotation -> transformationChain(annotation, item));
    }
    
    private void transformationChain(Annotation annotation, Item item) {
        new DateFormatTransformation()
                .nextChain(new CustomTransmformation()
                .nextChain(new ToBase64Transformation()
                .nextChain(new CatchAllTransformation()
                        ))).transform(annotation, item);
    }
    
}
