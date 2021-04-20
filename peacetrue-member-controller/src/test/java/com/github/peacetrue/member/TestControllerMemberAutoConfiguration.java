package com.github.peacetrue.member;

import com.github.peacetrue.spring.formatter.date.AutomaticDateFormatter;
import com.github.peacetrue.spring.formatter.date.AutomaticLocalDateFormatter;
import com.github.peacetrue.spring.formatter.date.AutomaticLocalDateTimeFormatter;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.ReactivePageableHandlerMethodArgumentResolver;
import org.springframework.data.web.ReactiveSortHandlerMethodArgumentResolver;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author xiayx
 */
@Configuration
@ImportAutoConfiguration(classes = {
        TestServiceMemberAutoConfiguration.class,
        WebMvcAutoConfiguration.class,
        HttpMessageConvertersAutoConfiguration.class,
        ControllerMemberAutoConfiguration.class,
        SpringDataWebAutoConfiguration.class,
})
@EnableAutoConfiguration
@ActiveProfiles("member-controller-test")
public class TestControllerMemberAutoConfiguration {

    @Bean
    public ReactivePageableHandlerMethodArgumentResolver reactivePageableHandlerMethodArgumentResolver() {
        return new ReactivePageableHandlerMethodArgumentResolver();
    }

    @Bean
    public ReactiveSortHandlerMethodArgumentResolver reactiveSortHandlerMethodArgumentResolver() {
        return new ReactiveSortHandlerMethodArgumentResolver();
    }

    @Bean
    public AutomaticDateFormatter dateFormatter() {
        return new AutomaticDateFormatter();
    }

    @Bean
    public AutomaticLocalDateTimeFormatter localDateTimeFormatter() {
        return new AutomaticLocalDateTimeFormatter();
    }

    @Bean
    public AutomaticLocalDateFormatter localDateFormatter() {
        return new AutomaticLocalDateFormatter();
    }

    @ControllerAdvice
    public static class StringTrimmerControllerAdvice {
        @InitBinder
        public void registerCustomEditors(WebDataBinder binder) {
            binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        }
    }
}
