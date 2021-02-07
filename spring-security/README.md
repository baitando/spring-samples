# Spring Security

This sample puts focus on securing web applications with Spring Security by leveraging the security filter as well as
method security.

In addition, this sample defines two different profiles. Using the `in-memory` profile, the users are defined in the web
security configuration using the Spring Security in memory authentication. Choosing the `ldap` profile, an embedded LDAP
directory is initialized with an LDIF file containing the same users. This embedded LDAP is then used for
authentication.

You can start the application, which will listen at port `8080`. The user `max` with password `maxpwd` is in the `users`
group and therefore allowed to access the resources. The user `melanie` with password `melaniepwd` is in the `admins`
group and not allowed to access the resources.
