package com.example.jojolduspringboot.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩() {
        //when
        String body = this.restTemplate.getForObject("/", String.class);

        //then
        System.out.println(body);
        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }

    @Test
    public void hello() {
        String hello = this.restTemplate.getForObject("/hello", String.class);

        System.out.println(hello);
        assertThat(hello).contains("hello");
    }

}