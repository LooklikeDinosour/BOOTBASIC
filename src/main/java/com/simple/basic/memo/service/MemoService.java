package com.simple.basic.memo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.simple.basic.command.MemoVO;

@Service("memoService")
public interface MemoService {
	
	public ArrayList<MemoVO> getList();
	public void writeMemo(MemoVO vo);
	public void delete(int num);
}
