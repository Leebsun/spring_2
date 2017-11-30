package com.iu.s2;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.board.BoardDTO;
import com.iu.notice.NoticeDTO;
import com.iu.notice.NoticeService;
import com.iu.util.ListData;


@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;

	
	
	@RequestMapping(value="noticeList")
	public String selectList(Model model, ListData listData){
	
		List<BoardDTO> ar = null;
		
		try {
			noticeService.selectList(listData, model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("board","notice" );
		
		
		return "board/boardList";
		
	}
	
	@RequestMapping(value="noticeView")
	public String selectOne(Model model, @RequestParam(defaultValue="0",required=false) int num){
		
		try {
			BoardDTO boardDTO=noticeService.selectOne(num);
			model.addAttribute("view", boardDTO);
			model.addAttribute("board", "notice");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "board/boardView";
	}
	
	@RequestMapping(value="noticeWrite",method=RequestMethod.POST)
	public String insert(RedirectAttributes rd,NoticeDTO noticeDTO){
		int result=0;
		try {
			result=noticeService.insert(noticeDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message="Fail";
		if(result>0){
			message="Success";
			
		}
		rd.addFlashAttribute("message", message);
		
		return "redirect:./noticeList";
	}
	
	@RequestMapping(value="noticeWrite",method=RequestMethod.GET)
	public String insert(Model model){
		

			model.addAttribute("board","notice");
	
		
		return "board/boardWrite";
	}
	
	
	
	
	
	
	
}
