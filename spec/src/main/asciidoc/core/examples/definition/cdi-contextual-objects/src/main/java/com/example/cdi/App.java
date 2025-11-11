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
            // 1. ContextChecker
            // Get the bean and run verifications
            System.out.println( "1. ContextChecker" );
            ContextChecker checker = container.select(ContextChecker.class).get();
            checker.checkAll();

            // 2. LifecycleBean - see metadata during lifecycle
            System.out.println( "2. LifecycleBean with metadata inspection" );
            LifecycleBean lifecycleBean = container.select(LifecycleBean.class).get();
            lifecycleBean.doWork();

            // 3. AttributeInspector - show all bean attributes
            System.out.println( "3. Bean Multiple Attributes" );
            AttributeInspector inspector = container.select(AttributeInspector.class).get();
            inspector.showAllAttributes(MultiAttributeBean.class);

        } finally {
            // Close container
            weld.shutdown();
        }
    }
}
