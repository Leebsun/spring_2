package com.iu.file;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.iu.util.FileSaver;

public class FileService {
	
	private FileSaver fileSaver;
	
	public List<String> fileSave(MultipartFile [] f1, HttpSession session) throws Exception{
		String filePath = session.getServletContext().getRealPath("resources/upload");
		ArrayList<String> names=new ArrayList<String>();
		
		for(MultipartFile f: f1){
			String fileName=fileSaver.save2(filePath,f);
			names.add(fileName);
		}
		
		return names;
	}

}
