package com.iu.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.DBConnector;
import com.iu.util.MakeRow;

public class NoticeDAO implements BoardDAO {
	//totalCount
	@Override
		public int getTotalCount() throws Exception {
			Connection con = DBConnector.getConnect();
			String sql = "select nvl(count(num), 0) from notice where "+"?"+" like ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+""+"%");
			ResultSet rs = st.executeQuery();
			rs.next();
			int result = rs.getInt(1);
			
			DBConnector.disConnect(rs, st, con);
			return result;
		}
		
		//hit update
		@Override
		public int hitUpdate(int num) throws Exception {
			Connection con = DBConnector.getConnect();
			String sql ="update notice set hit=hit+1 where num=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, num);
			int result = st.executeUpdate();
			
			DBConnector.disConnect(st, con);
			return result;
		}
		
		//delete
		@Override
		public int delete(int num) throws Exception {
			Connection con = DBConnector.getConnect();
			String sql ="delete notice where num=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, num);
			int result = st.executeUpdate();
			DBConnector.disConnect(st, con);
			
			return result;
		}
		
		//update
		@Override
		public int update(BoardDTO boardDTO) throws Exception{
			Connection con = DBConnector.getConnect();
			String sql ="update notice set writer=?, title=?, contents=? where num=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, boardDTO.getWriter());
			st.setString(2, boardDTO.getTitle());
			st.setString(3, boardDTO.getContents());
			st.setInt(4, boardDTO.getNum());
			int result = st.executeUpdate();
			
			
			DBConnector.disConnect(st, con);
			
			return result;
			
		}
		
		
		//write
		@Override
		public int insert(BoardDTO noticeDTO) throws Exception {
			Connection con = DBConnector.getConnect();
			String sql ="insert into notice values(board_seq.nextval,?,?,?,sysdate,0)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, noticeDTO.getWriter());
			st.setString(2, noticeDTO.getTitle());
			st.setString(3, noticeDTO.getContents());
			int result = st.executeUpdate();
			
			DBConnector.disConnect(st, con);
			
			return result;
			
		}
		
		
		//view
		@Override
		public BoardDTO selectOne(int num) throws Exception{
			Connection con = DBConnector.getConnect();
			
			String sql ="select * from notice where num=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, num);
			
			ResultSet rs = st.executeQuery();
			
			NoticeDTO noticeDTO=null;
			
			if(rs.next()) {
				noticeDTO = new NoticeDTO();
				noticeDTO.setNum(rs.getInt("num"));
				noticeDTO.setWriter(rs.getString("writer"));
				noticeDTO.setTitle(rs.getString("title"));
				noticeDTO.setContents(rs.getString("contents"));
				noticeDTO.setReg_date(rs.getDate("reg_date"));
				noticeDTO.setHit(rs.getInt("hit"));
			}
			
			DBConnector.disConnect(rs, st, con);
			
			return noticeDTO;
			
		}
		
		
		//list
		@Override
		public List<BoardDTO> selectList() throws Exception {
			Connection con = DBConnector.getConnect();
			
			List<BoardDTO> ar = new ArrayList<BoardDTO>();
			BoardDTO boardDTO = null;
			
			String sql = "select * from "
					+ "(select rownum R, N.* from "
					+ "(select * from notice order by num desc) N)"
					+ "where R between ? and ?";
			PreparedStatement st = con.prepareStatement(sql);
		
			st.setInt(1, 1);
			st.setInt(2, 10);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setNum(rs.getInt("num"));
				boardDTO.setWriter(rs.getString("writer"));
				boardDTO.setTitle(rs.getString("title"));
				boardDTO.setContents(rs.getString("contents"));
				boardDTO.setReg_date(rs.getDate("reg_date"));
				boardDTO.setHit(rs.getInt("hit"));
				ar.add(boardDTO);
			}
			
			DBConnector.disConnect(rs, st, con);
			
			return ar;
		}

}
