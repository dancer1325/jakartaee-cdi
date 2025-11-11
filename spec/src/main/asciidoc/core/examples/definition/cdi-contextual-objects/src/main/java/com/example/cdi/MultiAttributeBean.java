package com.example.cdi;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@RequestScoped
@Named("multiBean")
@Monitored
public class MultiAttributeBean implements Serializable, Runnable {
    
    @Override
    public void run() {
        System.out.println("MultiAttributeBean executing");
    }
    
    public void process() {
        System.out.println("Processing data");
    }
}
