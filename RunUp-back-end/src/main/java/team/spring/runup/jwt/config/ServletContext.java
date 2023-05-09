package team.spring.runup.jwt.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import team.spring.runup.jwt.interceptor.JwtInterceptor;

//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = {"team.spring.runup.jwt.controller","team.spring.runup.jwt.interceptor"})
//public class ServletContext implements WebMvcConfigurer {
//	
//	Logger log = LogManager.getLogger("case3");
//	
//	@Autowired
//	JwtInterceptor jwtInterceptor;
//	
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//							.allowedOrigins("*")
//							.allowedMethods("*")
//							.allowedHeaders("*")
//							.exposedHeaders("jwt-auth-token");
//	}
//	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) { // 인터셉터 등록
//	    registry.addInterceptor(jwtInterceptor)
//	            .addPathPatterns("/**") // Interceptor가 적용될 경로
//	            .excludePathPatterns("/login", "/websocket-chat/**");
//	}
//
//}
