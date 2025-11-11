# bean
## == source of contextual objects / define application state and/or logic
* [UserService](cdi-contextual-objects/src/main/java/com/example/cdi/UserService.java)
### == object / EXIST | context / managed -- by -- CDI
* [ContextChecker](cdi-contextual-objects/src/main/java/com/example/cdi/ContextChecker.java)
  * [run the app](cdi-contextual-objects/README.md) & check the logs
## may bear
### metadata / define its lifecycle
* [LifecycleBean](cdi-contextual-objects/src/main/java/com/example/cdi/LifecycleBean.java)
## == MULTIPLE attributes
* [AttributeInspector](cdi-contextual-objects/src/main/java/com/example/cdi/AttributeInspector.java) & [MultiAttributeBean](cdi-contextual-objects/src/main/java/com/example/cdi/MultiAttributeBean.java)

# contextual instances of the bean
* see commentaries `// contextual instances of the bean`
## container creates + destroys + associates them -- with -- appropiate context
* [ContainerDemo](cdi-contextual-objects/src/main/java/com/example/cdi/ContainerDemo.java)
## uses
### inject other objects (EVEN OTHER bean instances) / executed | SAME context
* [InjectionDemo](cdi-contextual-objects/src/main/java/com/example/cdi/InjectionDemo.java)

# bean developer
## may
### create interceptors
* see 
  * [Logged](cdi-contextual-objects/src/main/java/com/example/cdi/Logged.java) + 
  * [LoggingInterceptor](cdi-contextual-objects/src/main/java/com/example/cdi/LoggingInterceptor.java) + 
  * [InterceptedBean](cdi-contextual-objects/src/main/java/com/example/cdi/InterceptedBean.java) + 
  * [beans.xml](cdi-contextual-objects/src/main/resources/META-INF/beans.xml)'s `<interceptors>`
### reuse existing interceptors
* [ReuseInterceptorBean](cdi-contextual-objects/src/main/java/com/example/cdi/ReuseInterceptorBean.java)



