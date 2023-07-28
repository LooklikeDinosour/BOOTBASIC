package com.simple.basic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.basic.command.MemoVO;
import com.simple.basic.memo.service.MemoService;

@Controller
@RequestMapping("/memo")
public class MemoController {

	@Autowired
	@Qualifier("memoService")
	private MemoService memoService;

	//목록화면
	@GetMapping("/memoList")
	public String memoList(Model model, MemoVO vo) {

		ArrayList<MemoVO> list = memoService.getList();
		//System.out.println(mlist.toString());

		model.addAttribute("list", list);

		return "memo/memoList";
	}

	//글쓰기화면
	@GetMapping("/memoWrite")
	public String memoWrite() {
		return "memo/memoWrite";
	}
	
	//글등록
	@PostMapping("/memoForm") 
	public String memoForm(@Valid @ModelAttribute("vo") MemoVO vo, Errors errors, Model model) {
		//쌤은 ModelAttribute 안씀

		if(errors.hasErrors()) {

			List<FieldError> list = errors.getFieldErrors();

			for(FieldError fe : list) {

				if(fe.isBindingFailure()) {
					model.addAttribute("valid_"+ fe.getField(), "잘못입력했습니다.");
				} else {
					model.addAttribute("valid_" + fe.getField(), fe.getDefaultMessage());
				}
			}
			return "redirect:/memo/memoWrite";
		} else {
			memoService.writeMemo(vo);
			return "redirect:/memo/memoList";
		}
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("num") int num) {
		memoService.delete(num);
		return "redirect:/memo/memoList";
	}
	
	
}
