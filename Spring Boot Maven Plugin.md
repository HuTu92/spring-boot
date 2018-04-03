# Usage

## Running the application

该插件包含可用于从命令行启动应用程序的运行目标：

`mvn spring-boot:run`

默认情况下，应用程序直接从Maven JVM执行。如果你需要在分叉的进程中运行，你可以使用`fork`选项。

如果指定了`jvmArguments`或`agent`选项，或者`devtools`存在，分叉也会发生。

如果您需要指定某些JVM参数（即出于调试目的），则可以使用jvmArguments参数，请参阅[调试应用程序](https://docs.spring.io/spring-boot/docs/current/maven-plugin/examples/run-debug.html)以获取更多详细信息。

Spring Boot 1.3引入了`devtools`，这是一个模块，用于改进Spring Boot应用程序开发时的体验。

要启用它，只需将以下依赖项添加到您的项目中：

```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <version>2.0.0.RELEASE</version>
    <optional>true</optional>
  </dependency>
</dependencies>
```

当`devtools`运行时，它会在您重新编译应用程序时检测到更改，并自动刷新它。这不仅适用于资源，而且适用于代码。

它还提供一个LiveReload服务器，以便在项目发生变化时自动触发浏览器刷新。

Devtools也可以配置为只在静态资源发生变化时刷新浏览器（并忽略代码中的任何更改）。

只需在您的项目中包含以下属性：

```
spring.devtools.remote.restart.enabled=false
```

>spring-boot-devtools会在类路径上的文件发生更改时自动重启。
>当DevTools监视类路径资源时，触发重启的唯一方法是更新类路径。
>
>如果不想使用重启功能，可以使用`spring.devtools.restart.enabled`属性来禁用它。