package com.github.peacetrue.member;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Nullable;

/**
 * 会员服务接口
 *
 * @author xiayx
 */
public interface MemberService {

    /** 新增 */
    Mono<MemberVO> add(MemberAdd params);

    /** 分页查询 */
    Mono<Page<MemberVO>> query(@Nullable MemberQuery params, @Nullable Pageable pageable, String... projection);

    /** 全量查询 */
    Flux<MemberVO> query(MemberQuery params, @Nullable Sort sort, String... projection);

    /** 全量查询 */
    default Flux<MemberVO> query(MemberQuery params, String... projection) {
        return this.query(params, (Sort) null, projection);
    }

    /** 获取 */
    Mono<MemberVO> get(MemberGet params, String... projection);

    /** 是否存在 */
    Mono<Boolean> exists(MemberGet params);

    /** 修改 */
    Mono<Integer> modify(MemberModify params);

    /** 修改密码 */
    Mono<Integer> modifyPassword(MemberModifyPassword params);

    /** 重置密码 */
    Mono<Integer> resetPassword(MemberResetPassword params);

    /** 删除 */
    Mono<Integer> delete(MemberDelete params);

    /** 注册 */
    Mono<MemberVO> register(MemberRegister params);
}
