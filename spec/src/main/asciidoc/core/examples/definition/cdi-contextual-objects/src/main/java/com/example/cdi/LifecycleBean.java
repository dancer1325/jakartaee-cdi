package com.example.cdi;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.spi.Bean;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.inject.Inject;
import java.util.Set;

@ApplicationScoped
public class LifecycleBean {
    
    @Inject
    BeanManager beanManager;
    
    @PostConstruct
    public void init() {
        System.out.println("=== Bean Lifecycle: INIT ===");
        inspectSelf();
    }
    
    @PreDestroy
    public void cleanup() {
        System.out.println("=== Bean Lifecycle: DESTROY ===");
        inspectSelf();
    }
    
    public void doWork() {
        System.out.println("=== Bean Lifecycle: WORKING ===");
        inspectSelf();
    }
    
    private void inspectSelf() {
        Set<Bean<?>> beans = beanManager.getBeans(LifecycleBean.class);
        
        for (Bean<?> bean : beans) {
            System.out.println("Bean class: " + bean.getBeanClass());
            System.out.println("Scope: " + bean.getScope());
            System.out.println("Qualifiers: " + bean.getQualifiers());
        }
    }
}
