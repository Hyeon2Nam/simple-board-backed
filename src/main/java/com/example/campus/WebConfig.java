package com.example.campus;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // CORS 설정
        registry.addMapping("/api/**")  // /api/** 경로에 대해서 CORS 허용
                .allowedOrigins("http://localhost:3000")  // React 앱 주소
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 허용할 HTTP 메서드
                .allowCredentials(true)  // 쿠키 전송 허용
                .allowedHeaders("*");  // 허용할 헤더
    }
}
