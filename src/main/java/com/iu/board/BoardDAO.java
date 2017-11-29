package com.iu.board;

import java.util.List;

import com.iu.util.MakeRow;

public interface BoardDAO {
	//totalCount
		public int getTotalCount() throws Exception;
		
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
		public List<BoardDTO> selectList()throws Exception;

}
