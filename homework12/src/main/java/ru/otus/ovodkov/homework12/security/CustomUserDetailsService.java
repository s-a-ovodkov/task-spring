package ru.otus.ovodkov.homework12.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.otus.ovodkov.homework12.entities.User;
import ru.otus.ovodkov.homework12.repositories.UserRepository;

/**
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    try {
      final User user = userRepository.findByUsername(username)
          .orElseThrow(() -> new UsernameNotFoundException(username));
      return org.springframework.security.core.userdetails.User
          .withUsername(user.getUsername())
          .password("{bcrypt}" + user.getPassword())
          .roles("USER")
          .build();
    } catch (Exception exc) {
      exc.printStackTrace();
    }
    throw new UsernameNotFoundException(username);
  }
}
