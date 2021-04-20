package com.github.peacetrue.member;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * @author xiayx
 */
@Configuration
@EnableConfigurationProperties(ControllerMemberProperties.class)
@ComponentScan(basePackageClasses = ControllerMemberAutoConfiguration.class)
@PropertySource("classpath:/application-member-controller.yml")
public class ControllerMemberAutoConfiguration {


}
