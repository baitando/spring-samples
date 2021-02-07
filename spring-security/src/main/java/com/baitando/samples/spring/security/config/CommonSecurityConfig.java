package com.baitando.samples.spring.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Common specification of how paths should be secured independent of the identity store.
 */
public class CommonSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().hasRole("USER").and()
                .httpBasic().and()
                .csrf().disable();
    }
}
