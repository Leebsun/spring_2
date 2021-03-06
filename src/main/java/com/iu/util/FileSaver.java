package com.iu.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	//3. FileCopyUtils 
	public String save3(String filePath, MultipartFile multipartFile)throws Exception{
		String fileName = multipartFile.getOriginalFilename();
		fileName=fileName.substring(fileName.lastIndexOf("."));
		fileName = UUID.randomUUID().toString()+fileName;
		
		File file = new File(filePath, fileName);
		
		byte [] fileData = multipartFile.getBytes();
		FileCopyUtils.copy(fileData, file);
		
		return fileName;
		
	}
	
	
	//2. transfer
	public String save2(String filePath, MultipartFile multipartFile)throws Exception{
		String fileName = multipartFile.getOriginalFilename();
		fileName=fileName.substring(fileName.lastIndexOf("."));
		fileName = UUID.randomUUID().toString()+fileName;
		
		File file = new File(filePath, fileName);
		
		multipartFile.transferTo(file);
		
		return fileName;
	}
	
	
	//1. outputStream 사용
	public String save1(String filePath, MultipartFile multipartFile) throws Exception{
		String fileName = multipartFile.getOriginalFilename();
		fileName=fileName.substring(fileName.lastIndexOf("."));
		fileName = UUID.randomUUID().toString()+fileName;
		
		byte [] fileData = multipartFile.getBytes();
		
		File file = new File(filePath, fileName);
		FileOutputStream fo=null;
		try {
			fo = new FileOutputStream(file);
			fo.write(fileData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return fileName;
		
	}

}
