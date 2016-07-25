# RESTful Java #1
***
## Introduction to this series

This assumes you have working knowledge of web applications, how to create them and how to deploy them on server.
The tools I am going to use in this series are:

- Lifecycle Management: maven
- IDE: Eclipse
- Server: Wildfly

## Getting Started

Let's dive straight into it. Create a project using maven. Type the following command in your terminal in some directory where you want to experiment.
```bash
mvn archetype:create \
  -DgroupId="com.learnjavaee" \
  -DartifactId="helloworld" \
  -DarchetypeArtifactId=maven-archetype-webapp
```
This will create a webapp project.
This will create the following directory structure:
```bash
.
|-- pom.xml
`-- src
    `-- main
        |-- resources
        `-- webapp
            |-- index.jsp
            `-- WEB-INF
                `-- web.xml
```
We don't need index.jsp. You can safely remove it. Or if you are lazy to do that, leave it as it is.

### Step 1:
Add the Java EE dependency to your POM file.
```
<dependency>
	<groupId>javax</groupId>
	<artifactId>javaee-api</artifactId>
	<version>7.0</version>
</dependency>
```

### Step 2:
Create a class called `HelloResource` in `src/main/java`.
```Java
@Path("hello")
public class HelloResource {
	
	@GET
	public String greeting() {
		return "Hello, World!";
	}
	
}
```

### Step 3:
Create another class by name `ApplicationConfig` with content:

```Java
@ApplicationPath("helloworld")
public class ApplicationConfig extends Application {}
```

### Step 3:
That's it! All set. Now host your webapp on any container(Tomcat, Wildfly, Jetty, etc) and hit the URL:

`http://localhost:8080/helloworld/helloworld/hello`

And you will see the text returned by `greeting()` method. That is "Hello, World"

That was simple, wasn't it?

## Let's dissect the app now
### Step 1 was obvious!
### Step 2:
Next we created a POJO with annotation `@Path("hello")`. And added a method which returned `String` and had an `@GET` annotation.

`@Path`
This annotation defines the URI path on which the resource will serve replies. So in our case this resource file will serve on `/hello`.

`@GET`
This defines the HTTP method that will be served by the method. There are others which we will see later, but currently, this method will serve the `GET` requests. Whatever value is returned by this method is passed as response.

### Step 3:
We created another class, this time an application that will serve as root of all the the requests and responses. More on this class later. But for now this class will be required in all the projects we do.

### The URL
The URL we hit was:
`http://localhost:8080/helloworld/helloworld/hello`

The `localhost:8080` is well I am not going to talk about that. The 1st helloworld is out web app, the 2nd one is the `ApplicationPath` which we specified in `ApplicationConfig.java`. This was followed by the Resource path.



