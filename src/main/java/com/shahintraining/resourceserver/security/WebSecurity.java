package com.shahintraining.resourceserver.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author sh.khalajestanii
 * @project resource-server
 * @since 12/15/2021
 */
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                    .antMatchers(HttpMethod.GET,"/users")
                    .hasAnyAuthority("SCOPE_profile")
                  .anyRequest().authenticated()
                  .and()
                .oauth2ResourceServer()
                .jwt();
    }
}
