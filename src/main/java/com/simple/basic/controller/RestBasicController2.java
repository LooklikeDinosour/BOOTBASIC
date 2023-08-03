package com.simple.basic.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jni.Local;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simple.basic.command.SimpleVO;

@RestController //@Controller + @ResponseBody
public class RestBasicController2 {

	@GetMapping("/bazic")
	public String basic() {

		return "<h3>hello world</h3>";
	}

	//데이터 보내는 방법 -> @ResponseBody = 자바의 객체를 JSON형식으로 자동 변환
	@GetMapping("/getObject2")
	public SimpleVO getObject() {

		SimpleVO vo = new SimpleVO(1, "호옹", "길동", LocalDateTime.now());

		return vo;

	}

	@GetMapping("/getMap2")
	public Map<String, Object> getMap() {

		Map<String, Object> map = new HashMap<>();
		map.put("name", "호옹길동");

		return map;
	}

	@GetMapping("/getList2")
	public List<SimpleVO>  getList() {

		List<SimpleVO> list = new ArrayList<>();
		list.add(new SimpleVO(1, "호옹", "길동", LocalDateTime.now()));
		list.add(new SimpleVO(2, "잉", "길동", LocalDateTime.now()));

		return list;
	}

	//데이터를 받는 방법
	//get => 쿼리스트링 or 쿼리 파라미터 이용해서 주소에 담아서 넘김
	//post => form or JSON을 이용해서 body에 담아서 넘김

	//http://localhost:8181/getDat1?sno=5&first=이런젠장
	@GetMapping("/getDat1")
	public SimpleVO getDat1(SimpleVO vo) {
		System.out.println(vo.toString());

		return new SimpleVO(2, "이", "길동", LocalDateTime.now());
	}

	//http://localhost:8181/getDat2?snum=3&second=이런젠장
	@GetMapping("/getDat2")
	public SimpleVO getDat2(@RequestParam("snum") int snum,
			@RequestParam("second") String second) {
		System.out.println(snum);
		System.out.println(second);

		return new SimpleVO(2, "삼","길동", LocalDateTime.now());
	}

	//http://localhost:8181/getDat3/3/이런젠장
	@GetMapping("/getDat3/{sno}/{first}")
	public SimpleVO getDat3(@PathVariable("sno") int sno,
			@PathVariable("first") String first) {

		System.out.println(sno);
		System.out.println(first);

		return new SimpleVO(2, "오", "길동", LocalDateTime.now());
	}
	////////////////////////////////////
	//Post 방식의 데이터 받기
	//bomerang post 방식으로 변경 -> add form item

	//보내는 입장에서 form형식의 데이터를 써줘야함
	@PostMapping("/getForm1")
	public SimpleVO getForm(SimpleVO vo) {

		System.out.println(vo.toString());

		return new SimpleVO(2, "이잉", "길동", LocalDateTime.now());
	}
	//{ "sno" : 1,    "first" : "홍길동",    "last" : "이순신" }

	@PostMapping("/getJSON11")
	public SimpleVO getJSON1(@RequestBody SimpleVO vo) {

		System.out.println(vo.toString());

		return new SimpleVO(3, "힝", "딩동", LocalDateTime.now());

	}
	//{ "sno" : 4,    "first" : "호옹길동",    "last" : "이이순신" }
	@PostMapping("/getJSON22")
	public SimpleVO getJSON2(@RequestBody Map<String, Object> map) {
		System.out.println(map.toString());

		return new SimpleVO(2, "이", "길동", LocalDateTime.now());
	}

	////////////////////////////////////////////////////////////
	//consumer = 반드시 이 타입으로 보내라 명시
	//producer = 내가 이 타입으로 줄게! 명시 (default = json), xml을 사용하려면 xml 데이터 바인딩 라이브러리 필요

	//보내는 타입은 Text로 줄게, 너는 JSON 데이터로 보내라 
	@PostMapping(value="/getResult1", produces = "text/plain", consumes = "application/json")
	public String getResult(@RequestBody String str) {

		System.out.println(str);

		return "<h3>문자열</h3>";

	}
	
	@PostMapping("/createResponse1")
	public ResponseEntity<SimpleVO> createResponse1() {
		
		SimpleVO vo = new SimpleVO(1, "홍000", "기롱", LocalDateTime.now());
				
		//1st
		//ResponseEntity<SimpleVO> result = new ResponseEntity<>(vo, HttpStatus.OK); //데이터, 상태코드
		
		//2nd
		//헤더에 대한 내용정의 - 꼭 필요한 경우가 아니라면 전달 안해도 됌.
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "JSON WEB TOKEN~~");
		header.add("Content-Type", "application/json");
		header.add("Access-Control-Allow-Order", "*");
		
		ResponseEntity<SimpleVO> result = new ResponseEntity<>(vo, header, HttpStatus.OK);
		
		System.out.println(result);
		
		return result;
	
		
	
	
	}
}