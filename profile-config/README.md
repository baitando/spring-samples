# Profile Specific Configuration

This sample can be used to play around with the configuration possibilities available in Spring Boot applications.

The sample consists of a service interface and two different implementations of this service.
Each service is active in a seperate profile.
Both of them retrieve a config value with Spring Boot capabilities and return this value in a service method.

The starter gets a service implementation injected.
It prints the reference of the injected service implementation as well as the config value which was retrieved by this implementation.

## Switch Profiles

There are two profiles called `one` and `two` available.
Switching between the profiles switches the service implementation.

The switch can be done in the IDE, directly via `-Dspring.profiles.active=<profile>` or by configuring it in `application.yml`.
This also works in case of a fat jar, which is started via command line.

## Change config

The config value used by the service implementations has the key `blubber`.
It can be overwritten with `-Dblubber=<value>` on the command line.
You can also overwrite it by creating a profile specific configuration named `application-<profile.yml` file inside `src/main/resources`.
This also works in case of a fat jar, which is started via command line.
In this case place the file in the same directory as the jar file or in a sub-folder called `config`.