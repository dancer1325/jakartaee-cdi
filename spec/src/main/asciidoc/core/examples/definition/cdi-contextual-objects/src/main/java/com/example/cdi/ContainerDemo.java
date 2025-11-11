package com.example.cdi;

import jakarta.enterprise.context.spi.CreationalContext;
import jakarta.enterprise.inject.spi.Bean;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.inject.Inject;
import java.util.Set;

public class ContainerDemo {
    
    @Inject
    BeanManager beanManager; // This IS the container
    
    public void showContainerActions() {
        System.out.println("=== CONTAINER Actions ===");
        
        // 1. Container CREATES instances
        System.out.println("1. Container CREATES instance:");
        Set<Bean<?>> beans = beanManager.getBeans(LifecycleBean.class);
        Bean<?> bean = beanManager.resolve(beans);
        CreationalContext<?> ctx = beanManager.createCreationalContext(bean);
        Object instance = beanManager.getReference(bean, LifecycleBean.class, ctx);
        System.out.println("   Container created: " + instance.getClass().getSimpleName());
        
        // 2. Container ASSOCIATES with context
        System.out.println("2. Container ASSOCIATES with context:");
        System.out.println("   Scope: " + bean.getScope().getSimpleName());
        System.out.println("   Context active: " + beanManager.getContext(bean.getScope()).isActive());
        
        // 3. Container will DESTROY when context ends
        System.out.println("3. Container will DESTROY when context ends");
        ctx.release(); // Container destroys here
        System.out.println("   Instance destroyed by container");
    }
}
