package com.github.peacetrue.member;

import com.github.peacetrue.core.OperatorCapableImpl;
import com.github.peacetrue.validation.constraints.multinotnull.MultiNotNull;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * @author xiayx
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class MemberModify extends OperatorCapableImpl<Long> {

    private static final long serialVersionUID = 0L;

    /** 主键 */
    @NotNull
    private Long id;
    /** 会员名 */
    @NotNull
    @Size(min = 6, max = 32)
    @Pattern(regexp = "[0-9a-zA-Z.\\-*]+")
    private String username;

}
