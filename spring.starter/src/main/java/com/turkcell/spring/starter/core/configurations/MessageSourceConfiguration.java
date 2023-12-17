package com.turkcell.spring.starter.core.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class MessageSourceConfiguration { //Dil desteği
    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSource(){ //Çevirileri nereden çekecek
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages"); // resourcede verdiğimiz isim
        return source;

    }

    @Bean
    public LocaleResolver localeResolver(){ //Kullanıcının o anda uygulamayı hangi dilde kullanacağını seçme biçimi

        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        acceptHeaderLocaleResolver.setDefaultLocale(new Locale("tr")); //Default dil
        return acceptHeaderLocaleResolver;
    }

}
