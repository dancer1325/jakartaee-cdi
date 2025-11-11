package com.example.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.spi.Bean;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.inject.Inject;

@ApplicationScoped
public class InjectionDemo {
    
    // Inject other objects
    @Inject
    BeanManager beanManager;  // Contextual instance injects BeanManager
    
    // Inject other bean instances | SAME context
    @Inject
    LifecycleBean lifecycleBean;

    // Inject other bean instances | SAME context
    @Inject
    UserService userService;
    
    public void showInjections() {
        System.out.println("=== Contextual Instance Injections ===");
        
        // Show injected objects are available
        System.out.println("1. Injected BeanManager: " + (beanManager != null));
        System.out.println("2. Injected LifecycleBean: " + (lifecycleBean != null));
        System.out.println("3. Injected UserService: " + (userService != null));
        
        // PROVE they're in SAME context by checking scope and instances
        System.out.println("4. PROOF all in SAME ApplicationScoped context:");
        
        // Check this bean's scope
        Bean<?> thisBean = beanManager.resolve(beanManager.getBeans(InjectionDemo.class));
        System.out.println("   InjectionDemo scope: " + thisBean.getScope().getSimpleName());
        
        // Check injected bean scopes
        Bean<?> lifecycleBeanDef = beanManager.resolve(beanManager.getBeans(LifecycleBean.class));
        Bean<?> userServiceBeanDef = beanManager.resolve(beanManager.getBeans(UserService.class));
        System.out.println("   LifecycleBean scope: " + lifecycleBeanDef.getScope().getSimpleName());
        System.out.println("   UserService scope: " + userServiceBeanDef.getScope().getSimpleName());
        
        // Get same instances from context - proves they're shared
        LifecycleBean lifecycleRef1 = this.lifecycleBean;
        LifecycleBean lifecycleRef2 = (LifecycleBean) beanManager.getReference(lifecycleBeanDef, LifecycleBean.class, 
            beanManager.createCreationalContext(null));
        
        System.out.println("5. SAME instance from context: " + (lifecycleRef1 == lifecycleRef2));
        
        // Use injected beans - all in same context
        this.lifecycleBean.doWork();
        this.userService.registerUser("testUser");
    }
}
