package com.github.peacetrue.member;

import com.github.peacetrue.core.OperatorCapableImpl;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * @author xiayx
 */
@Getter
@Setter
@ToString(exclude = {"oldPassword", "newPassword"}, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class MemberModifyPassword extends OperatorCapableImpl<Long> {

    private static final long serialVersionUID = 0L;

    /** 主键 */
    @NotNull
    private Long id;
    /** 原密码 */
    @NotNull
    @Size(min = 6, max = 255)
    @Pattern(regexp = "[0-9a-zA-Z.\\-*]+")
    private String oldPassword;
    /** 新密码 */
    @NotNull
    @Size(min = 6, max = 255)
    @Pattern(regexp = "[0-9a-zA-Z.\\-*]+")
    private String newPassword;

}
