package com.github.peacetrue.member;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author xiayx
 */
@Data
@ConfigurationProperties(prefix = "peacetrue.member")
public class ServiceMemberProperties {

    /** 忘记密码后，重置时使用的默认密码 */
    @NotNull
    @Size(min = 1, max = 255)
    private String defaultPassword = "123456";

    /** 查询的最大记录条数 */
    @NotNull
    @Min(1)
    private Integer maxCountOfQuery = 100;
}
