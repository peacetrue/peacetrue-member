package com.github.peacetrue.member;

import com.github.peacetrue.core.OperatorCapableImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * @author xiayx
 */
@Getter
@Setter
@ToString(exclude = "password", callSuper = true)
public class MemberAdd extends OperatorCapableImpl<Long> {

    private static final long serialVersionUID = 0L;

    /** 会员名 */
    @NotNull
    @Size(min = 6, max = 32)
    @Pattern(regexp = "[0-9a-zA-Z.\\-*]+")
    private String username;
    /** 密码 */
    @NotNull
    @Size(min = 6, max = 255)
    @Pattern(regexp = "[0-9a-zA-Z.\\-*]+")
    private String password;

}
