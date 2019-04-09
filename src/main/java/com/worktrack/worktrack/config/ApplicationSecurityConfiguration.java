package com.worktrack.worktrack.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**","/img/**","/js/**","/video/**").permitAll()
                .antMatchers("/","/company-index","/worker-index").anonymous()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/company/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/company/home")
                .and()
                .logout()
                .logoutSuccessUrl("/");

    }
}
