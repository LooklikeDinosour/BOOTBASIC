package com.simple.basic.command;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MemoVO {
	
	private int mno;
	@NotNull(message = "내용을 작성해주세요")
	private String memo;
	@NotNull(message = "연락받을 전화번호")
	private String phone;
	@NotEmpty(message = "비밀번호 4자리")
	private String pw;
	
	private String secret;
	

}
