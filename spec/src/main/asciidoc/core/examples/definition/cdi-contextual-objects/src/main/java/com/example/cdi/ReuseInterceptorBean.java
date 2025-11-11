package com.example.cdi;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReuseInterceptorBean {
    
    // Reuse existing @Logged interceptor
    @Logged
    public void methodWithLogging() {
        System.out.println("Method reusing existing LoggingInterceptor");
    }
    
    // Reuse existing @Monitored interceptor  
    @Monitored
    public void methodWithMonitoring() {
        System.out.println("Method reusing existing MonitoringInterceptor");
    }
    
    // Reuse BOTH existing interceptors
    @Logged
    @Monitored
    public void methodWithBothInterceptors() {
        System.out.println("Method reusing BOTH existing interceptors");
    }
}
