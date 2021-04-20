package com.github.peacetrue.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 会员控制器
 *
 * @author xiayx
 */
@Slf4j
@RestController
@RequestMapping(value = "/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Mono<MemberVO> addByForm(MemberAdd params) {
        log.info("新增会员信息(请求方法+表单参数)[{}]", params);
        return memberService.add(params);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<MemberVO> addByJson(@RequestBody MemberAdd params) {
        log.info("新增会员信息(请求方法+JSON参数)[{}]", params);
        return memberService.add(params);
    }

    @GetMapping(params = "page")
    public Mono<Page<MemberVO>> query(MemberQuery params, Pageable pageable, String... projection) {
        log.info("分页查询会员信息(请求方法+参数变量)[{}]", params);
        return memberService.query(params, pageable, projection);
    }

    @GetMapping
    public Flux<MemberVO> query(MemberQuery params, Sort sort, String... projection) {
        log.info("全量查询会员信息(请求方法+参数变量)[{}]", params);
        return memberService.query(params, sort, projection);
    }

    @GetMapping("/{id}")
    public Mono<MemberVO> getByUrlPathVariable(@PathVariable Long id, String... projection) {
        log.info("获取会员信息(请求方法+路径变量)详情[{}]", id);
        return memberService.get(new MemberGet(id), projection);
    }

    @RequestMapping("/get")
    public Mono<MemberVO> getByPath(MemberGet params, String... projection) {
        log.info("获取会员信息(请求路径+参数变量)详情[{}]", params);
        return memberService.get(params, projection);
    }

    @RequestMapping("/exists")
    public Mono<Boolean> existsByPath(MemberGet params) {
        log.info("检查会员(请求路径+参数变量)[{}]是否存在", params);
        return memberService.exists(params);
    }

    @PutMapping(value = {"", "/*"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Mono<Integer> modifyByForm(MemberModify params) {
        log.info("修改会员信息(请求方法+表单参数)[{}]", params);
        return memberService.modify(params);
    }

    @PutMapping(value = {"", "/*"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Integer> modifyByJson(@RequestBody MemberModify params) {
        log.info("修改会员信息(请求方法+JSON参数)[{}]", params);
        return memberService.modify(params);
    }

    @PutMapping(value = {"/password", "/*/password"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Mono<Integer> modifyPasswordByForm(MemberModifyPassword params) {
        log.info("修改会员密码(请求方法+表单参数)[{}]", params);
        return memberService.modifyPassword(params);
    }

    @PutMapping(value = {"/password", "/*/password"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Integer> modifyPasswordByJson(@RequestBody MemberModifyPassword params) {
        log.info("修改会员密码(请求方法+JSON参数)[{}]", params);
        return memberService.modifyPassword(params);
    }

    @PutMapping(value = {"/password/reset", "/*/password/reset"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Mono<Integer> resetPasswordByForm(MemberResetPassword params) {
        log.info("重置会员密码(请求方法+表单参数)[{}]", params);
        return memberService.resetPassword(params);
    }

    @PutMapping(value = {"/password/reset", "/*/password/reset"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Integer> resetPasswordByJson(@RequestBody MemberResetPassword params) {
        log.info("重置会员密码(请求方法+JSON参数)[{}]", params);
        return memberService.resetPassword(params);
    }

    @DeleteMapping("/{id}")
    public Mono<Integer> deleteByUrlPathVariable(@PathVariable Long id) {
        log.info("删除会员信息(请求方法+URL路径变量)[{}]", id);
        return memberService.delete(new MemberDelete(id));
    }

    @DeleteMapping(params = "id")
    public Mono<Integer> deleteByUrlParamVariable(MemberDelete params) {
        log.info("删除会员信息(请求方法+URL参数变量)[{}]", params);
        return memberService.delete(params);
    }

    @RequestMapping(value = "/delete")
    public Mono<Integer> deleteByPath(MemberDelete params) {
        log.info("删除会员信息(请求路径+URL参数变量)[{}]", params);
        return memberService.delete(params);
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Mono<MemberVO> registerByForm(MemberRegister params) {
        log.info("注册会员信息(请求方法+表单参数)[{}]", params);
        params.setOperatorId(1L);
        return memberService.register(params);
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<MemberVO> registerByJson(@RequestBody MemberRegister params) {
        log.info("注册会员信息(请求方法+JSON参数)[{}]", params);
        params.setOperatorId(1L);
        return memberService.register(params);
    }

}
