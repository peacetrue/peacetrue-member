package com.github.peacetrue.member;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Objects;

/**
 * @author xiayx
 */
@Configuration
@EnableConfigurationProperties(ServiceMemberProperties.class)
@ComponentScan(basePackageClasses = ServiceMemberAutoConfiguration.class)
@PropertySource("classpath:/application-member-service.yml")
public class ServiceMemberAutoConfiguration {

    private ServiceMemberProperties properties;

    public ServiceMemberAutoConfiguration(ServiceMemberProperties properties) {
        this.properties = Objects.requireNonNull(properties);
    }

}
