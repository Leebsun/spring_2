package com.iu.board;

import java.util.List;

import org.springframework.ui.Model;

import com.iu.util.RowNum;


public interface BoardDAO {
	//totalCount
		public int getTotalCount(RowNum rowNum) throws Exception;
		
		//update
		public int update(BoardDTO boardDTO) throws Exception;
		
		//delete
		public int delete(int num)throws Exception;
		
		//hitUpdate
		public int hitUpdate(int num)throws Exception;
		
		//insert
		public int insert(BoardDTO boardDTO) throws Exception;
		
		//selectOne
		public BoardDTO selectOne(int num) throws Exception;
		
		//selectList
		public List<BoardDTO> selectList(RowNum rowNum)throws Exception;

}
