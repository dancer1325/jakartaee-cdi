package com.example.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class App 
{
    public static void main( String[] args )
    {

        // Initialize CDI container
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        try {
            // Get the bean and run verifications
            ContextChecker checker = container.select(ContextChecker.class).get();
            checker.checkAll();

        } finally {
            // Close container
            weld.shutdown();
        }
    }
}
