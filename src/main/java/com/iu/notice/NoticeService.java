package com.iu.notice;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.ListData;
import com.iu.util.Pager;
import com.iu.util.RowNum;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	@Inject
	private FileDAO fileDAO;

	@Override
	public int insert(BoardDTO boardDTO,HttpSession session) throws Exception {
		int num = noticeDAO.getNum();
		String filePath = session.getServletContext().getRealPath("resources/upload");
		ArrayList<FileDTO> names=new ArrayList<FileDTO>();
		
		FileSaver fileSaver = new FileSaver();
		FileDTO fileDTO=null;
		for(MultipartFile f: ((NoticeDTO)boardDTO).getF1()){
			fileDTO = new FileDTO();
			
			fileDTO.setFilename(fileSaver.save2(filePath,f));
			fileDTO.setOriname(f.getOriginalFilename());
			fileDTO.setNum(num);
			names.add(fileDTO);
			fileDAO.insert(fileDTO);
		}
		
		boardDTO.setNum(num);

		return noticeDAO.insert(boardDTO);
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
		// TODO Auto-generated method stub
		noticeDAO.hitUpdate(num);
		return noticeDAO.selectOne(num);
	}

	@Override
	public void selectList(ListData listData, Model model) throws Exception {
		// TODO Auto-generated method stub
		
		//?섏씠吏?
		RowNum rowNum = listData.makeRow();
		Pager pager = listData.makePage(noticeDAO.getTotalCount(rowNum));
		model.addAttribute("list", noticeDAO.selectList(rowNum));
		model.addAttribute("pager", pager);
	}

}
