package com.github.peacetrue.member;

import com.github.peacetrue.core.OperatorCapableImpl;
import com.github.peacetrue.validation.constraints.multinotnull.MultiNotNull;
import lombok.*;


/**
 * @author xiayx
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@MultiNotNull(propertyNames = {"id", "username"})
public class MemberGet extends OperatorCapableImpl<Long> {

    private static final long serialVersionUID = 0L;

    private Long id;
    private String username;

    public MemberGet(Long id) {
        this.id = id;
    }
}
