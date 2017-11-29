package com.iu.s2;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iu.board.BoardDTO;
import com.iu.notice.NoticeService;


@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;

	
	
	@RequestMapping(value="noticeList")
	public String selectList(Model model){
		List<BoardDTO> ar = null;
		
		try {
			ar=noticeService.selectList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("list", ar)
		.addAttribute("board","notice" );
		
		
		return "board/boardList";
		
	}

}
