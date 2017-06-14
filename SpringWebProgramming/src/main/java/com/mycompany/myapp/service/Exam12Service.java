package com.mycompany.myapp.service;

import java.util.List;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Image;
import com.mycompany.myapp.dto.Exam12Member;

public interface Exam12Service {
	public void boardWrite(Exam12Board board);	
	public List<Exam12Board> boardListAll();
	public List<Exam12Board> boardListPage(int pageNo, int rowsPerPage);
	public int boardTotalRows();
	public Exam12Board getBoard(int bno);
	public String boardCheckBpassword(int bno, String bpassword);
	public void boardUpdate(Exam12Board board);
	public void boardDelete(int bno);
	
	public void memberJoin(Exam12Member member);
	public List<Exam12Member> memberListPage(int pageNo, int rowsPerPage);
	public int memberTotalRows();
	public Exam12Member getMember(String mid);
	public String memberCheckMpassword(String mid, String mpassword);
	public void memberUpdate(Exam12Member member);
	public void memberDelete(String mid);
	public String memberDownload(String mid);
	
	public void imageWrite(Exam12Image image);	
	public List<Exam12Image> imageListAll();
	public List<Exam12Image> imageListPage(int pageNo, int rowsPerPage);
	public int imageTotalRows();
	public Exam12Image getImage(int no);
	public String imageCheckPassword(int no, String password);
	public void imageUpdate(Exam12Image image);
	public void imageDelete(int no);
	public String imageDownload(int no);
}
