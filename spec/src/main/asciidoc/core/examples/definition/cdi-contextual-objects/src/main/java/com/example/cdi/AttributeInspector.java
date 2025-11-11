package com.example.cdi;

import jakarta.enterprise.inject.spi.Bean;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.inject.Inject;
import jakarta.interceptor.InterceptorBinding;
import java.lang.annotation.Annotation;
import java.util.Set;

public class AttributeInspector {
    
    @Inject
    BeanManager beanManager;

    public void showAllAttributes(Class<?> classType) {
        Set<Bean<?>> beans = beanManager.getBeans(classType);
        
        for (Bean<?> bean : beans) {
            System.out.println("=== Bean Multiple Attributes ===");
            System.out.println("Bean types: " + bean.getTypes());
            System.out.println("Qualifiers: " + bean.getQualifiers());
            System.out.println("Scope: " + bean.getScope());
            System.out.println("Bean name: " + bean.getName());
            System.out.println("Bean class: " + bean.getBeanClass());
            
            // Check interceptor bindings via reflection
            Class<?> beanClass = bean.getBeanClass();
            System.out.print("Interceptor bindings: ");
            for (Annotation annotation : beanClass.getAnnotations()) {
                if (annotation.annotationType().isAnnotationPresent(InterceptorBinding.class)) {
                    System.out.print(annotation.annotationType().getSimpleName() + " ");
                }
            }
            System.out.println();
        }
    }
}
