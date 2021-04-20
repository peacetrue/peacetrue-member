package com.github.peacetrue.member;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.function.Consumer;

import static com.github.peacetrue.member.MemberServiceImplTest.EASY_RANDOM;

/**
 * @author xiayx
 */
@SpringBootTest(classes = TestControllerMemberAutoConfiguration.class)
@AutoConfigureWebTestClient
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberControllerTest {

    @Autowired
    private WebTestClient client;

    @Test
    @Order(10)
    public void add() {
        this.client.post().uri("/members")
                .bodyValue(MemberServiceImplTest.ADD)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(MemberVO.class).value((Consumer<MemberVO>) vo -> MemberServiceImplTest.vo = vo);
    }

    @Test
    @Order(20)
    public void queryForPage() {
        this.client.get()
                .uri("/members?page=0")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().jsonPath("$.totalElements").isEqualTo(1);
    }

    @Test
    @Order(30)
    public void queryForList() {
        this.client.get()
                .uri("/members")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().jsonPath("$.size()").isEqualTo(1);
    }

    @Test
    @Order(40)
    public void get() {
        this.client.get()
                .uri("/members/{0}", MemberServiceImplTest.vo.getId())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(MemberVO.class).isEqualTo(MemberServiceImplTest.vo);
    }


    @Test
    @Order(45)
    public void exists() {
        this.client.get()
                .uri("/members/exists?id=", MemberServiceImplTest.vo.getId())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(Boolean.class).isEqualTo(true);
    }


    @Test
    @Order(50)
    public void modify() {
        MemberModify modify = MemberServiceImplTest.MODIFY;
        modify.setId(MemberServiceImplTest.vo.getId());
        this.client.put()
                .uri("/members/{id}", MemberServiceImplTest.vo.getId())
                .bodyValue(modify)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(Integer.class).isEqualTo(1);
    }

    @Test
    @Order(55)
    public void modifyPassword() {
        MemberModifyPassword modify = EASY_RANDOM.nextObject(MemberModifyPassword.class);
        modify.setId(MemberServiceImplTest.vo.getId());
        modify.setOldPassword(MemberServiceImplTest.ADD.getPassword());
        modify.setOperatorId(MemberServiceImplTest.vo.getId());
        this.client.put()
                .uri("/members/{id}/password", MemberServiceImplTest.vo.getId())
                .bodyValue(modify)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(Integer.class).isEqualTo(1);
    }

    @Test
    @Order(56)
    public void resetPassword() {
        MemberResetPassword modify = new MemberResetPassword();
        modify.setId(MemberServiceImplTest.vo.getId());
        modify.setOperatorId(MemberServiceImplTest.vo.getId());
        this.client.put()
                .uri("/members/{id}/password/reset", MemberServiceImplTest.vo.getId())
                .bodyValue(modify)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(Integer.class).isEqualTo(1);
    }

    @Test
    @Order(60)
    public void delete() {
        this.client.delete()
                .uri("/members/{0}", MemberServiceImplTest.vo.getId())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(Integer.class).isEqualTo(1);
    }

    @Test
    @Order(70)
    public void register() {
        this.client.post().uri("/members/register")
                .bodyValue(MemberServiceImplTest.REGISTER)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(MemberVO.class).value((Consumer<MemberVO>) vo -> MemberServiceImplTest.vo = vo);
    }

}
