package com.example.oauthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/******
 * TODO :
 * TokenGnerer 를 통한 토큰 생성 규칙 첨가
 * TokenApprove 를 통항 리플레시 토큰 규칙 추가
 *
 *
 */

@SpringBootApplication
public class OauthServiceOldApplication {
    //https://knoc-story.tistory.com/80
    public static void main(String[] args) {
        SpringApplication.run(OauthServiceOldApplication.class, args);
    }

}
