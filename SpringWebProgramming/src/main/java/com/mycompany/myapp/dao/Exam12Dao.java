package com.mycompany.myapp.dao;

import java.util.List;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Image;
import com.mycompany.myapp.dto.Exam12Member;

public interface Exam12Dao {
	public int boardInsert(Exam12Board board);
	public List<Exam12Board> boardSelectAll();
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage);
	public int boardCountAll();
	public Exam12Board boardSelectByBno(int bno);
	public void boardUpdateBhitcount(int bno, int bhitcount);
	public void boardUpdate(Exam12Board board);
	public void boardDelete(int bno);
	
	public String memberInsert(Exam12Member member);		
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage);
	public int memberCountAll();
	public Exam12Member memberSelectByMid(String mid);	
	public void memberUpdate(Exam12Member member);
	public void memberDelete(String mid);
	public String memberDownload(String mid);
	
	public int imageInsert(Exam12Image image);
	public List<Exam12Image> imageSelectAll();
	public List<Exam12Image> imageSelectPage(int pageNo, int rowsPerPage);
	public int imageCountAll();
	public Exam12Image imageSelectByNo(int no);
	public void imageUpdateHitcount(int no, int hitcount);
	public void imageUpdate(Exam12Image image);
	public void imageDelete(int no);
	public String imageDownload(int no);
	
	
}
