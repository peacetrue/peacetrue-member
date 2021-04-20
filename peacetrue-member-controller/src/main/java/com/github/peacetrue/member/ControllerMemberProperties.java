package com.github.peacetrue.member;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 控制器配置
 *
 * @author xiayx
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "peacetrue.user")
public class ControllerMemberProperties {

}
