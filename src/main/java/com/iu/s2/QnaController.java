package com.iu.s2;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.board.BoardDTO;
import com.iu.notice.NoticeDTO;
import com.iu.qna.QnaDTO;
import com.iu.qna.QnaService;
import com.iu.util.ListData;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {
	
	@Inject
	private QnaService qnaService;
	
	@RequestMapping(value="qnaUpdate", method=RequestMethod.POST)
	public String update(QnaDTO qnaDTO, RedirectAttributes rd, HttpSession session){
		String message="Fail";
		try{
			int result=qnaService.update(qnaDTO, session);
			if(result>0){
				message="Success";
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		rd.addFlashAttribute("message", message);
		return "redirect:qnaList";
	}

	@RequestMapping(value="qnaUpdate", method=RequestMethod.GET)
	public String update(int num, Model model){
		try {
			BoardDTO boardDTO=qnaService.selectOne(num);
			model.addAttribute("view", boardDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("board", "qna");
		return "board/boardUpdate";
	}


	@RequestMapping(value="qnaDelete")
	public String delete(int num, RedirectAttributes rd, HttpSession session){
		int result=0;
		try {
			result = qnaService.delete(num, session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message="Fail";
		if(result>0){
			message="Success";
		}

		rd.addFlashAttribute("message", message);

		return "redirect:./qnaList";
	}

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
	public String insert(RedirectAttributes rd, QnaDTO boardDTO, HttpSession session){
		int result = 0;
		
			try {
				result = qnaService.insert(boardDTO,session);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String message="fail";
			if(result>0){
				message="Success";
			}
			rd.addFlashAttribute("message", message);

			return "redirect:./qnaList";
	}

}
