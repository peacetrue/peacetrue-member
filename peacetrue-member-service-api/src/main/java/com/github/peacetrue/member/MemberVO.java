package com.github.peacetrue.member;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xiayx
 */
@Data
@ToString(exclude = "password")
public class MemberVO implements Serializable {

    private static final long serialVersionUID = 0L;

    /** 主键 */
    private Long id;
    /** 会员名 */
    private String username;
    /** 密码 */
    private String password;
    /** 创建者主键 */
    private Long creatorId;
    /** 创建时间 */
    private LocalDateTime createdTime;
    /** 修改者主键 */
    private Long modifierId;
    /** 最近修改时间 */
    private LocalDateTime modifiedTime;

}
