package com.simple.basic.memo.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.MemoVO;

@Mapper
public interface MemoMapper {
	
	public ArrayList<MemoVO> getList();
	public void writeMemo(MemoVO vo);
	public void delete(int num);
}
