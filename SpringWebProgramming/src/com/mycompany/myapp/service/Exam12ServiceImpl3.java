package com.mycompany.myapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam12Dao;
import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Image;
import com.mycompany.myapp.dto.Exam12Member;

@Component
public class Exam12ServiceImpl3 implements Exam12Service {
	@Resource(name="exam12DaoImpl3")
	private Exam12Dao dao;
	
	@Override
	public void boardWrite(Exam12Board board) {		
		dao.boardInsert(board);
	}
	
	@Override
	public List<Exam12Board> boardListAll() {
		List<Exam12Board> list = dao.boardSelectAll();
		return list;
	}
	
	@Override
	public List<Exam12Board> boardListPage(int pageNo, int rowsPerPage) {
		List<Exam12Board> list = dao.boardSelectPage(pageNo, rowsPerPage);
		return list;
	}
	
	@Override
	public int boardTotalRows() {
		int totalRows = dao.boardCountAll();
		return totalRows;
	}
	
	@Override
	public Exam12Board getBoard(int bno) {
		Exam12Board board = dao.boardSelectByBno(bno);
		board.setBhitcount(board.getBhitcount()+1);
		dao.boardUpdateBhitcount(bno, board.getBhitcount());
		return board;
	}
	
	@Override
	public String boardCheckBpassword(int bno, String bpassword) {
		String result="fail";
		Exam12Board board = dao.boardSelectByBno(bno);
		if(board.getBpassword().equals(bpassword)){
			result="success";
		} 
		return result;
	}
	
	@Override
	public void boardUpdate(Exam12Board board) {
		dao.boardUpdate(board);
		
	}
	
	@Override
	public void boardDelete(int bno) {
		dao.boardDelete(bno);		
	}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void memberJoin(Exam12Member member) {
		dao.memberInsert(member);
		
	}

	@Override
	public List<Exam12Member> memberListPage(int pageNo, int rowsPerPage) {
		List<Exam12Member> list = dao.memberSelectPage(pageNo, rowsPerPage);
		return list;
	}

	@Override
	public int memberTotalRows() {
		int totalRows = dao.memberCountAll();
		return totalRows;
	}
	
	@Override
	public Exam12Member getMember(String mid) {
		Exam12Member member = dao.memberSelectByMid(mid);		
		
		return member;
	}
	
	@Override
	public String memberCheckMpassword(String mid, String mpassword) {
		String result="fail";
		Exam12Member member = dao.memberSelectByMid(mid);
		if(member.getMpassword().equals(mpassword)){
			result="success";
		} 
		return result;
	}
	
	@Override
	public void memberUpdate(Exam12Member member) {
		dao.memberUpdate(member);
		
	}
	
	@Override
	public void memberDelete(String mid) {
		dao.memberDelete(mid);		
	}
	
	@Override
	public String memberDownload(String mid) {
		String msavedfilename="";
		msavedfilename=dao.memberDownload(mid);
		return msavedfilename;
		
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void imageWrite(Exam12Image image) {		
		dao.imageInsert(image);
	}
	
	@Override
	public List<Exam12Image> imageListAll() {
		List<Exam12Image> list = dao.imageSelectAll();
		return list;
	}
	
	@Override
	public List<Exam12Image> imageListPage(int pageNo, int rowsPerPage) {
		List<Exam12Image> list = dao.imageSelectPage(pageNo, rowsPerPage);
		return list;
	}
	
	@Override
	public int imageTotalRows() {
		int totalRows = dao.imageCountAll();
		return totalRows;
	}
	
	
	
	@Override
	public String imageCheckPassword(int no, String password) {
		String result="fail";
		Exam12Image image = dao.imageSelectByNo(no);
		if(image.getPassword().equals(password)){
			result="success";
		} 
		return result;
	}
	
	@Override
	public void imageUpdate(Exam12Image image) {
		dao.imageUpdate(image);
		
	}
	
	@Override
	public void imageDelete(int no) {
		dao.imageDelete(no);		
	}
	
	@Override
	public String imageDownload(int no) {
		String filename="";
		filename=dao.imageDownload(no);
		return filename;
		
	}

	@Override
	public Exam12Image getImage(int no) {
		Exam12Image image = dao.imageSelectByNo(no);
		image.setHitcount(image.getHitcount()+1);
		dao.imageUpdateHitcount(no, image.getHitcount());
		return image;
	}
	
	


}
