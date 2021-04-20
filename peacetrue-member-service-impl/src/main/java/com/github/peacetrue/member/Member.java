package com.github.peacetrue.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 会员实体类
 *
 * @author xiayx
 */
@Getter
@Setter
@ToString(exclude = "password")
@Table("member")
public class Member implements Serializable {

    private static final long serialVersionUID = 0L;

    /** 主键 */
    @Id
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
