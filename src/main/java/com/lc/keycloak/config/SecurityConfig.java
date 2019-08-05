package com.lc.keycloak.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * security config.
 *
 * @author zyz.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // .antMatchers("/product").permitAll()
                .antMatchers("/product").hasRole("USER")
                .antMatchers("/user").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login-error");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                // spring security 5 提供加密方式.
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("lc")
                // 密码应相应方式加密.
                .password(new BCryptPasswordEncoder().encode("1"))
                .roles("USER");
    }


}
