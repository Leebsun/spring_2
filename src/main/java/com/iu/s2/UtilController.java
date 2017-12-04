package com.iu.s2;

import java.io.File;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.iu.file.PhotoDTO;
import com.iu.util.FileSaver;

@Controller
@RequestMapping(value="/util/*")
public class UtilController {
	
	@RequestMapping(value="photoUpload", method=RequestMethod.POST)
	public String smartEditor(PhotoDTO photoDTO, HttpSession session){
	
		//service
		String filePath = session.getServletContext().getRealPath("/");
		filePath=filePath+"resources"+File.separator+"upload";
		File file = new File(filePath);
		System.out.println(filePath);
		if(!file.exists()){
			file.mkdirs();
		}
		FileSaver fs = new FileSaver();
		String fileName="";
		//String result="";
		StringBuffer stringBuffer = new StringBuffer();
		try {
			fileName=fs.save1(filePath, photoDTO.getFiledata());
			//result="&bNewLine=true&sFileName="+photoDTO.getFiledata().getOriginalFilename()+"&sFileURL=/"+session.getServletContext().getContextPath()+File.separator+"upload"+File.separator+fileName;
			stringBuffer.append("&bNewLine=true&sFileName=");
			stringBuffer.append(photoDTO.getFiledata().getOriginalFilename());
			stringBuffer.append("&sFileURL=");
			stringBuffer.append(session.getServletContext().getContextPath());
			stringBuffer.append("/resources/");
			stringBuffer.append("upload");
			stringBuffer.append("/");
			stringBuffer.append(fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		
		
		System.out.println(photoDTO.getCallback()+photoDTO.getCallback_func()+stringBuffer.toString());
		return "redirect:"+photoDTO.getCallback()+photoDTO.getCallback_func()+stringBuffer.toString();
	}

}