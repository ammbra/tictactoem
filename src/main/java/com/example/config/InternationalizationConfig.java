package com.example.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class InternationalizationConfig implements WebMvcConfigurer {
   @Bean
   public LocaleResolver localeResolver() {
      SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
      sessionLocaleResolver.setDefaultLocale(Locale.FRANCE);
      return sessionLocaleResolver;
   }
}