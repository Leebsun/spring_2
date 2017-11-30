package com.iu.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.util.ListData;
import com.iu.util.Pager;
import com.iu.util.RowNum;

public class NoticeService implements BoardService {
	
	

	private NoticeDAO noticeDAO;
	
	public NoticeService() {
		
	}

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		noticeDAO.insert(boardDTO);
		
		return 0;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		noticeDAO.hitUpdate(num);
		return noticeDAO.selectOne(num);
	}

	@Override
	public List<BoardDTO> selectList(ListData listData, Model model) throws Exception {
		
		RowNum rowNum=listData.makeRow();
		int totalCount = noticeDAO.getTotalCount(rowNum);
		Pager pager=listData.makePage(totalCount);
		model.addAttribute("pager",pager) ;
		model.addAttribute("list",noticeDAO.selectList(rowNum)) ;
		
		return noticeDAO.selectList(rowNum);
	}

}
