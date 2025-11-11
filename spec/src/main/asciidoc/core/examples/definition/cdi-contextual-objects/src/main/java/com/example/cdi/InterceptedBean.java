package com.example.cdi;

import jakarta.enterprise.context.ApplicationScoped;

// bean / use the interceptor -- via -- @Logged
@ApplicationScoped
@Logged
public class InterceptedBean {
    
    public void businessMethod() {
        System.out.println("Executing business logic");
    }
    
    public String processData(String data) {
        System.out.println("Processing: " + data);
        return "Processed: " + data;
    }
}
