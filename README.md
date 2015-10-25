write-properties-file-maven-plugin
==================================

Maven plugin to write Properties Files

```xml
      <plugin>
        <groupId>com.internetitem</groupId>
        <artifactId>write-properties-file-maven-plugin</artifactId>
        <version>1.0.1</version>
        <executions>
          <execution>
            <id>one</id>
            <phase>compile</phase>
            <goals>
                <goal>write-properties-file</goal>
            </goals>
            <configuration>
              <filename>test.properties</filename>
              <properties>
                <property>
                  <name>one</name>
                  <value>1</value>
                </property>
                <property>
                  <name>artifactId</name>
                  <value>My Artifact ID is ${project.artifactId}</value>
                </property>
              </properties>
            </configuration>
          </execution>
        </executions>
      </plugin>
```

