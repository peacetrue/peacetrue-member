package com.github.peacetrue.member;

import com.github.peacetrue.core.OperatorCapableImpl;
import com.github.peacetrue.core.Range;
import lombok.*;


/**
 * @author xiayx
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class MemberQuery extends OperatorCapableImpl<Long> {

    public static final MemberQuery DEFAULT = new MemberQuery();

    private static final long serialVersionUID = 0L;

    /** 主键 */
    private Long[] id;
    /** 会员名 */
    private String username;
    /** 创建者主键 */
    private Long creatorId;
    /** 创建时间 */
    private Range.LocalDateTime createdTime;
    /** 修改者主键 */
    private Long modifierId;
    /** 最近修改时间 */
    private Range.LocalDateTime modifiedTime;

    public MemberQuery(Long[] id) {
        this.id = id;
    }

}
