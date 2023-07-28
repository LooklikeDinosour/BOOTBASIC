package com.simple.basic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.simple.basic.controller.HomeController;

@Configuration
public class WebConfig implements WebMvcConfigurer {//자바 빈설정을 하기 위해서 상속
	
	//IOC확인
	@Autowired
	ApplicationContext applicationContext;
	
	
	//value애너테이션 사용 - application.properties 값불러오기
	@Value("${spring.datasource.url}")
	String url;
	
	
	
	@Bean // 요 메서드를 빈으로 생성 - return 객체를 반환하는 모형을 만들면, 빈으로 등록
	public void test() {
		
//		TestBean test = applicationContext.getBean(TestBean.class);
//		System.out.println("TestBean이 빈으로 등록됨 : " + test);
//	
//		HomeController con = applicationContext.getBean(HomeController.class);
//		System.out.println("homecontroller가 빈으로 등록됨 : " + con);
//		
//		int count = applicationContext.getBeanDefinitionCount();
//		System.out.println("IOC안에 빈의개수 : " + count);
//		
//		System.out.println("application프로퍼티 키값 : " + url);
//		
		
		
	}
	
	//빈 생성 2가지 전략
	//@Controller, @Service의 이용해서 반으로 등록
	//스프링설정파일에 빈으로 등록
	//return 객체를 반환하는 모형을 만들면, 빈으로 등록
	
	
	@Bean
	public TestBean test2() {
		TestBean b = new TestBean();
		return b;
	}
	

}
