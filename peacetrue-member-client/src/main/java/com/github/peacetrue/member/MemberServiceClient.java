package com.github.peacetrue.member;

import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Nullable;

/**
 * 会员客户端
 *
 * @author xiayx
 */
@ReactiveFeignClient(name = "peacetrue-member")
public interface MemberServiceClient extends MemberService {

    @PostMapping(value = "/members")
    Mono<MemberVO> add(MemberAdd params);

    @GetMapping(value = "/members", params = "page")
    Mono<Page<MemberVO>> query(@Nullable @SpringQueryMap MemberQuery params, @Nullable Pageable pageable, @SpringQueryMap String... projection);

    @GetMapping(value = "/members", params = "sort")
    Flux<MemberVO> query(@SpringQueryMap MemberQuery params, Sort sort, @SpringQueryMap String... projection);

    @GetMapping(value = "/members")
    Flux<MemberVO> query(@SpringQueryMap MemberQuery params, @SpringQueryMap String... projection);

    @GetMapping(value = "/members/get")
    Mono<MemberVO> get(@SpringQueryMap MemberGet params, @SpringQueryMap String... projection);

    @GetMapping(value = "/members/get")
    Mono<Boolean> exists(@SpringQueryMap MemberGet params);

    @PutMapping(value = "/members")
    Mono<Integer> modify(MemberModify params);

    @PutMapping(value = "/members/password")
    Mono<Integer> modifyPassword(MemberModifyPassword params);

    @PutMapping(value = "/members/password/reset")
    Mono<Integer> resetPassword(MemberResetPassword params);

    @GetMapping(value = "/members/delete")
    Mono<Integer> delete(@SpringQueryMap MemberDelete params);

    @GetMapping(value = "/members/register")
    Mono<MemberVO> register(@SpringQueryMap MemberRegister params);

}
