# Pre Logging

When a Spring Boot test is started, there are `DEBUG` level messages disregarding the configuration in `application.yml` and `application.properties`.
The reason for this is, that those log messages are written before Spring Boot loads the default configuration files.

This sample shows how to control the log level for such messages.
To modify the log level for the messages written before Spring Boot loads the logging configuration, the logging backend specific configuration file needs to be provided.
By default, Logback is used as logging backend.
Therefore the log level can be modified in a file called `logback.xml` in the classpath root.

* The log level before Spring Boot is started is `WARN` which is set in `logback.xml`.
* The log level after Spring Boot is started is `DEBUG` which is set in `application.yml`.