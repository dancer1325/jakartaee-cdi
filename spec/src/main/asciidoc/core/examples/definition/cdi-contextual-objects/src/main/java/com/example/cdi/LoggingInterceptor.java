package com.example.cdi;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Logged
@Interceptor
public class LoggingInterceptor {
    
    @AroundInvoke
    public Object logMethod(InvocationContext ctx) throws Exception {
        System.out.println("*** Bean developer created interceptor ***");
        System.out.println("Before method: " + ctx.getMethod().getName());
        
        Object result = ctx.proceed();
        
        System.out.println("After method: " + ctx.getMethod().getName());
        return result;
    }
}
