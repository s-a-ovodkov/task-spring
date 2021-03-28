package ru.otus.ovodkov.homework12.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ru.otus.ovodkov.homework12.repositories.UserRepository;

/**
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
@RequiredArgsConstructor
@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

  private final UserRepository userRepository;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .formLogin().and()
        .authorizeRequests()
        .antMatchers("/login").permitAll()
        .anyRequest().authenticated();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(new CustomUserDetailsService(userRepository));
  }
}
