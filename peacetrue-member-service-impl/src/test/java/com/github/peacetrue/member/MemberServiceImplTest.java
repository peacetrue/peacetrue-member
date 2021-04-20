package com.github.peacetrue.member;

import com.github.peacetrue.spring.util.BeanUtils;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import reactor.test.StepVerifier;

import java.io.Serializable;


/**
 * @author : xiayx
 * @since : 2020-05-22 16:43
 **/
@SpringBootTest(classes = TestServiceMemberAutoConfiguration.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MemberServiceImplTest {

    public static final EasyRandom EASY_RANDOM = new EasyRandom(new EasyRandomParameters().randomize(Serializable.class, () -> "operatorName"));
    public static final MemberAdd ADD = EASY_RANDOM.nextObject(MemberAdd.class);
    public static final MemberModify MODIFY = EASY_RANDOM.nextObject(MemberModify.class);
    public static final MemberRegister REGISTER = EASY_RANDOM.nextObject(MemberRegister.class);
    public static MemberVO vo;

    static {
        ADD.setOperatorId(EASY_RANDOM.nextObject(Long.class));
        MODIFY.setOperatorId(EASY_RANDOM.nextObject(Long.class));
        REGISTER.setOperatorId(EASY_RANDOM.nextObject(Long.class));
    }

    @Autowired
    private MemberServiceImpl service;

    @Test
    @Order(10)
    void add() {
        service.add(ADD)
                .as(StepVerifier::create)
                .assertNext(data -> {
                    Assertions.assertEquals(data.getCreatorId(), ADD.getOperatorId());
                    vo = data;
                })
                .verifyComplete();
    }

    @Test
    @Order(20)
    void queryForPage() {
        MemberQuery params = BeanUtils.map(vo, MemberQuery.class);
        service.query(params, PageRequest.of(0, 10))
                .as(StepVerifier::create)
                .assertNext(page -> Assertions.assertEquals(1, page.getTotalElements()))
                .verifyComplete();
    }

    @Test
    @Order(30)
    void queryForList() {
        MemberQuery params = BeanUtils.map(vo, MemberQuery.class);
        service.query(params)
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    @Order(40)
    void get() {
        MemberGet params = BeanUtils.map(vo, MemberGet.class);
        service.get(params)
                .as(StepVerifier::create)
                .assertNext(item -> Assertions.assertEquals(vo.getUsername(), item.getUsername()))
                .verifyComplete();
    }

    @Test
    @Order(45)
    void exists() {
        MemberGet params = BeanUtils.map(vo, MemberGet.class);
        service.exists(params)
                .as(StepVerifier::create)
                .assertNext(item -> Assertions.assertEquals(true, item))
                .verifyComplete();
    }

    @Test
    @Order(50)
    void modify() {
        MemberModify params = MODIFY;
        params.setId(vo.getId());
        service.modify(params)
                .as(StepVerifier::create)
                .expectNext(1)
                .verifyComplete();
    }

    @Test
    @Order(55)
    void modifyPassword() {
        MemberModifyPassword params = EASY_RANDOM.nextObject(MemberModifyPassword.class);
        params.setId(vo.getId());
        params.setOldPassword(ADD.getPassword());
        params.setOperatorId(vo.getId());
        service.modifyPassword(params)
                .as(StepVerifier::create)
                .expectNext(1)
                .verifyComplete();
    }

    @Test
    @Order(56)
    void resetPassword() {
        MemberResetPassword params = new MemberResetPassword();
        params.setId(vo.getId());
        params.setOperatorId(vo.getId());
        service.resetPassword(params)
                .as(StepVerifier::create)
                .expectNext(1)
                .verifyComplete();
    }

    @Test
    @Order(60)
    void delete() {
        MemberDelete params = new MemberDelete(vo.getId());
        service.delete(params)
                .as(StepVerifier::create)
                .expectNext(1)
                .verifyComplete();
    }

    @Test
    @Order(70)
    void register() {
        service.register(REGISTER)
                .as(StepVerifier::create)
                .assertNext(data -> {
                    Assertions.assertEquals(data.getCreatorId(), REGISTER.getOperatorId());
                    vo = data;
                })
                .verifyComplete();
    }
}
