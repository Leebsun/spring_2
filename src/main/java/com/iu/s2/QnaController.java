package com.iu.s2;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iu.board.BoardDTO;
import com.iu.qna.QnaService;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {
	
	@Inject
	private QnaService qnaService;
	
	@RequestMapping(value="qnaList")
	public String selectList(Model model){
		List<BoardDTO> ar=null;
		
		try {
			ar=qnaService.selectList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("list", ar).addAttribute("board", "qna");
		
		
		return "board/boardList";
	}
			
}
