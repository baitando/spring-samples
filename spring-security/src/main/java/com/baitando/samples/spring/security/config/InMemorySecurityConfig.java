package com.baitando.samples.spring.security.config;

import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * A web security configuration, which relies on static dummy users stored directly in-memory.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Profile({"default", "in-memory"})
public class InMemorySecurityConfig extends CommonSecurityConfig {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("melanie").password("{noop}melaniepwd").roles("ADMINS").and()
                .withUser("max").password("{noop}maxpwd").roles("USERS");
    }
}
