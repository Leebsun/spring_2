package com.iu.member;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iu.file.FileDAO;
import com.iu.util.FileSaver;

@Service
public class MemberService {
	
	
	@Inject
	private MemberDAO memberDAO;
	@Inject
	private FileDAO fileDAO;
	@Inject
	private FileSaver fileSaver;
	
	
	public void login(){
		
	}
	
	public void join(){
		
	}
	

}
