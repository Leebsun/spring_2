package com.iu.s2;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iu.board.BoardDTO;
import com.iu.qna.QnaService;
import com.iu.util.ListData;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {
	
	@Inject
	private QnaService qnaService;

	@RequestMapping(value="qnaList")
	public String selectList(Model model, ListData listData){

			try {
				qnaService.selectList(listData, model);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("board", "qna");
		
		return "board/boardList";
	}
	
	@RequestMapping(value="qnaView")
	public String selectOne(Model model, @RequestParam(defaultValue="0",required=false)int num){
		
		try {
			BoardDTO boardDTO = qnaService.selectOne(num);
			model.addAttribute("view", boardDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("board", "qna");
		
		return "board/boardView";
	}
	
	@RequestMapping(value="qnaWrite", method={RequestMethod.GET})
	public String insert(Model model){
		model.addAttribute("board", "qna");
		return "board/boardWrite";
	}
	
	@RequestMapping(value="qnaWrite", method={RequestMethod.POST})
	public String insert(Model model, BoardDTO boardDTO){
		
		try {
			int result = qnaService.insert(boardDTO);
			model.addAttribute("board", "qna");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:./qnaList";
	}

}
