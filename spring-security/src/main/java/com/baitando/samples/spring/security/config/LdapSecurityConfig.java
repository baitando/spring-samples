package com.baitando.samples.spring.security.config;

import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * A web security configuration, which relies on static dummy users stored in an in-memory LDAP directory.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Profile("ldap")
public class LdapSecurityConfig extends CommonSecurityConfig {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                .userDnPatterns("uid={0},ou=people")
                .groupSearchBase("ou=groups")
                .groupSearchFilter("uniqueMember={0}")
                .contextSource()
                .url("ldap://localhost:8389/dc=baitando,dc=com")
                .and()
                .passwordCompare()
                .passwordAttribute("userPassword");
    }
}
