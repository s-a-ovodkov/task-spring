package ru.otus.ovodkov.homework12.configs;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация Layout Dialect-а Thymeleaf-а
 *
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
@Configuration
public class DialectConfig {

  @Bean
  public LayoutDialect layoutDialect() {
    return new LayoutDialect();
  }
}
