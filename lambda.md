---
title: "AWS Lambda"
repo: "https://github.com/seedstack/aws-addon"
author: Adrien LAUER
parent: "Amazon Web Services"
description: "Official integration of popular Amazon Web Services (AWS) products."
weight: -1
tags:
    - cloud
zones:
    - Addons
menu:
    AddonAWS:
        weight: 20
---

This module supports the [AWS Lambda](https://aws.amazon.com/lambda/details) server-less architecture.<!--more-->

# Dependencies
 
{{< dependency g="org.seedstack.addons.aws" a="aws-lambda" >}}

# Usage

The add-on uses on the [interface-based approach](http://docs.aws.amazon.com/lambda/latest/dg/java-handler-using-predefined-interfaces.html) 
of AWS Lambda. To declare a SeedStack-enabled request handler, extend the {{< java "org.seedstack.aws.lambda.BaseRequestHandler" >}} 
class:

```java
public class SomeRequestHandler extends BaseRequestHandler<String, String> {
    @Inject
    @Named("en")
    private Greeter greeter;

    @Override
    public String handleRequest(String input, Context context) {
        return greeter.greet(input);
    }
}
```

The {{< java "org.seedstack.aws.lambda.BaseRequestHandler" >}} class will initialize SeedStack on the first call of the
lambda function. Your lambda can then be injected like any SeedStack class. Interception is not supported on the request
handler itself but can be used on all other classes.

{{% callout tips %}}
Initialization is only performed during a lambda **cold start** but it is recommended to keep your lambda code focused and 
small so the initialization time is kept to a minimum.
{{% /callout %}}

{{% callout tips %}}
All [sources of events](http://docs.aws.amazon.com/lambda/latest/dg/invoking-lambda-function.html) are supported.
{{% /callout %}}
 
# Packaging

Packaging should be done according to the [AWS lambda packaging rules](http://docs.aws.amazon.com/lambda/latest/dg/lambda-java-how-to-create-deployment-package.html),
that is using the Maven shade plugin instead of normal SeedStack capsule:

```xml
<build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-shade-plugin</artifactId>
        <version>2.3</version>
        <configuration>
          <createDependencyReducedPom>false</createDependencyReducedPom>
        </configuration>
        <executions>
          <execution>
            <phase>package</phase>
            <goals>
              <goal>shade</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>  
```
