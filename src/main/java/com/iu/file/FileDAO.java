package com.iu.file;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import com.iu.util.DBConnector;


@Repository
public class FileDAO {
	
	//insert
	public int insert(FileDTO fileDTO)throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "insert into upload values(board_seq.nextval,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, fileDTO.getNum());
		st.setString(2, fileDTO.getFilename());
		st.setString(3, fileDTO.getOriname());
		
		int result=st.executeUpdate();
		DBConnector.disConnect(con, st);
		
		return result;
		
	}

}
