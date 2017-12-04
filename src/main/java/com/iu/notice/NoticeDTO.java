package com.iu.notice;

import org.springframework.web.multipart.MultipartFile;

import com.iu.board.BoardDTO;

public class NoticeDTO extends BoardDTO{
	
	private MultipartFile [] f1;

	public MultipartFile[] getF1() {
		return f1;
	}

	public void setF1(MultipartFile[] f1) {
		this.f1 = f1;
	}

}
