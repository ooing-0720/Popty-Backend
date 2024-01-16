package com.popty.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiV1() {
        return new OpenAPI()
                .info(new Info()
                        .title("Popty API 명세서")
                        .description("일일이벤트 맞춤형 공간 예약 플랫폼 'Popty'")
                        .version("1.0.0"));
    }

}
