package com.simple.basic.memo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.basic.command.MemoVO;

@Service("memoService")
public class MemoServiceImpl implements MemoService {
	
	@Autowired
	private MemoMapper memoMapper;

	@Override
	public ArrayList<MemoVO> getList() {
		
		ArrayList<MemoVO> list = memoMapper.getList();
		//System.out.println(list.toString());
		
		return list;
	}

	@Override
	public void writeMemo(MemoVO vo) {
		
		memoMapper.writeMemo(vo);
		
	}

	@Override
	public void delete(int num) {
		memoMapper.delete(num);
	}

}
