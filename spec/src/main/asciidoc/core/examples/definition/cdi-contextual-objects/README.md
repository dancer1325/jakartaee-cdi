# how has it been created?
* 
  ```
  mvn archetype:generate -DgroupId=com.example.cdi -DartifactId=cdi-contextual-objects\ 
   -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
  ```
* | "pom.xml", add
    ```
      <dependencies>
        <dependency>
            <groupId>org.jboss.weld.se</groupId>
            <artifactId>weld-se-core</artifactId>
            <version>5.1.0.Final</version>
        </dependency>
    </dependencies>
    ```
* create [beans.xml](src/main/resources/META-INF/beans.xml)

# how to run?
* `mvn compile exec:java -Dexec.mainClass="Main"`
