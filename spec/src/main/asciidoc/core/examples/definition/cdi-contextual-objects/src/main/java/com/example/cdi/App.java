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
            ContextChecker checker = container.select(ContextChecker.class).get();              // contextual instances of the bean
            checker.checkAll();

            // 2. LifecycleBean - see metadata during lifecycle
            System.out.println( "2. LifecycleBean with metadata inspection" );
            LifecycleBean lifecycleBean = container.select(LifecycleBean.class).get();          // contextual instances of the bean
            lifecycleBean.doWork();

            // 3. AttributeInspector - show all bean attributes
            System.out.println( "3. Bean Multiple Attributes" );
            AttributeInspector inspector = container.select(AttributeInspector.class).get();    // contextual instances of the bean
            inspector.showAllAttributes(MultiAttributeBean.class);

            // 4. ContainerDemo - show container actions
            System.out.println( "4. Container Actions" );
            ContainerDemo demo = container.select(ContainerDemo.class).get();
            demo.showContainerActions();

            // 5. InjectionDemo - show contextual instances injecting other objects
            System.out.println( "5. Contextual Instance Injections" );
            InjectionDemo injectionDemo = container.select(InjectionDemo.class).get();
            injectionDemo.showInjections();

            // 6. InterceptedBean - show bean developer created interceptors
            System.out.println( "6. Bean Developer Created Interceptors" );
            InterceptedBean interceptedBean = container.select(InterceptedBean.class).get();
            interceptedBean.businessMethod();
            interceptedBean.processData("test data");

        } finally {
            // Close container
            weld.shutdown();
        }
    }
}
