package com.david.bankruptcy.util;

import java.lang.reflect.Field;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.stereotype.Component;

import com.david.bankruptcy.exception.NullObjectCopyException;

@Component
public class NullAwareBeanUtilsBean<T> {

  public void copyProperties(T source, T target) {
    if (source == null || target == null) {
      throw new NullObjectCopyException("Can not copy properties from/to null objects");
    }

    final BeanWrapper wrapedSource = PropertyAccessorFactory.forBeanPropertyAccess(source);
    final BeanWrapper wrapedTarget = PropertyAccessorFactory.forBeanPropertyAccess(target);

    for (final Field property : target.getClass().getDeclaredFields()) {
      Object propertyValue = wrapedSource.getPropertyValue(property.getName());

      if (propertyValue != null) {
        wrapedTarget.setPropertyValue(property.getName(), propertyValue);
      }
    }
  }

}
