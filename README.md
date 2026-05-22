This project adapts the core functionality of the [Cimari](https://github.com/eggy03/cimari) library
into a RESTful HTTP service built with Quarkus.

> [!IMPORTANT]
> Note, that this service is meant only for [supported](https://github.com/eggy03/cimari#supported-windows-versions)
> versions of Windows

## Development

Run the application in development mode with live reload enabled:

```shell
./mvnw quarkus:dev
```

The application will start on:

```text
http://localhost:8080
```

Quarkus Dev UI is available during development at:

```text
http://localhost:8080/q/dev
```

You can change the port using

```shell
./mvnw quarkus:dev "-Dquarkus.http.port=<port>"
```

---

## Building From Source

### JVM Mode

To produce a self-contained executable JAR:

```bash
./mvnw clean package
```

Run the generated artifact using:

```bash
java -jar target/cimari-rest-*-runner.jar
```

Set your custom port with:

```shell
 java "-Dquarkus.http.port=<port>" -jar target/cimari-rest-*-runner.jar
```

### Native Mode

Build a native executable using GraalVM or Mandrel:

```shell
./mvnw package -Dnative
```

Run the executable with:

```shell
./target/cimari-rest-*-runner
```

Set your custom port with:

```shell
./target/cimari-rest-*-runner "-Dquarkus.http.port=<port>"
```

---

## API Documentation

OpenAPI specifications are exposed at:

```text
/q/openapi?format=json
```

Swagger UI is enabled in development mode and available at:

```text
/q/swagger-ui
```

Swagger UI is disabled in production builds by default.

---

## Related Projects

- [Cimari](https://github.com/eggy03/cimari)
