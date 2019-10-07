//package com.projects.stockviewer.dbservice.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//@EnableWebSecurity
//@Configuration
//public class SpringSecurityWebAppConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser("ashish").password("{noop}kingkong").roles("USER").and()
//                .withUser("varma").password("{noop}kingkong").roles("ADMIN");
//    }
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests()
//                .anyRequest()
//                .fullyAuthenticated()
//                .and()
//                .httpBasic();
//        httpSecurity.csrf().disable();
//    }
//}
