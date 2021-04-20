package com.github.peacetrue.member;

import com.github.peacetrue.core.OperatorCapableImpl;
import lombok.*;

import javax.validation.constraints.NotNull;


/**
 * @author xiayx
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class MemberResetPassword extends OperatorCapableImpl<Long> {

    private static final long serialVersionUID = 0L;

    /** 主键 */
    @NotNull
    private Long id;

}
