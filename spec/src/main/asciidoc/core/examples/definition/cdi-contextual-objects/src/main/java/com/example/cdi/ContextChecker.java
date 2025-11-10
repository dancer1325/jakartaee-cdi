package com.example.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.spi.Context;
import jakarta.enterprise.inject.spi.Bean;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.inject.Inject;

@ApplicationScoped
public class ContextChecker {
    
    @Inject
    UserService service1;
    
    @Inject  
    UserService service2;
    
    @Inject
    BeanManager beanManager;
    
    public void checkAll() {
        checkProxy();
        checkSingleton();
        checkContext();
        checkInjectionVsManual();
    }
    
    // 1. Verify it's a proxy
    public void checkProxy() {
        System.out.println("Actual class: " + service1.getClass().getName());
        System.out.println("Is CDI proxy: " + service1.getClass().getName().contains("Proxy"));
    }
    
    // 2. Verify singleton in @ApplicationScoped
    public void checkSingleton() {
        System.out.println("Same instance: " + (service1 == service2));
        System.out.println("Same hashCode: " + (service1.hashCode() == service2.hashCode()));
    }
    
    // 3. Access context programmatically
    public void checkContext() {
        Context appContext = beanManager.getContext(ApplicationScoped.class);
        System.out.println("Context active: " + appContext.isActive());
        
        Bean<UserService> bean = (Bean<UserService>) beanManager.getBeans(UserService.class).iterator().next();
        UserService instance = appContext.get(bean);
        System.out.println("Managed instance: " + (instance != null));
    }
    
    // 4. Verify injection vs manual creation
    public void checkInjectionVsManual() {
        UserService manual = new UserService(); // NOT managed by CDI
        
        System.out.println("Manual class: " + manual.getClass().getName());
        System.out.println("Injected class: " + service1.getClass().getName());
        System.out.println("Are different: " + !manual.getClass().equals(service1.getClass()));
    }
}
