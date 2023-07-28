package com.simple.basic;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.simple.basic.command.BuilderVO;
import com.simple.basic.command.BuilderVO.Builder;
import com.simple.basic.command.BuilderVO2;
import com.simple.basic.command.BuilderVO2.BuilderVO2Builder;

@SpringBootTest //스프링부트 테스트클래스
public class JDBCTest {
	
	//빌더 패턴의 확인
	@Test
	public void testCode01() {
		//import 주의
//		Builder b = BuilderVO.builder();
//		//setter 메서드
//		b = b.age(10);
//		b = b.name("홍길동");
//		BuilderVO vo = b.build();
		
		//빌더.세터.세터.빌드;
		BuilderVO vo = BuilderVO.builder().age(20).name("홍길동").build();
		//vo는 setter가 없기 때문에 객체불변성을 보장
		//vo.set
	
		System.out.println(vo.toString());
		
		BuilderVO2 vo2 = BuilderVO2.builder().age(30).name("드루가이").build();
		
		System.out.println(vo2.toString());
	}


}
