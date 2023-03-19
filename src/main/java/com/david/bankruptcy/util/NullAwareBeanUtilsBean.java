package com.david.bankruptcy.util;

import java.lang.reflect.Field;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

public class NullAwareBeanUtilsBean {

  public static void copyProperties(Object source, Object target) throws Exception {
    if (source == null || target == null || source.getClass() != target.getClass()) {
      throw new Exception("Error copying properties");
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
