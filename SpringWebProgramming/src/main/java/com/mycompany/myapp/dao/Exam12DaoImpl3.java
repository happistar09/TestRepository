package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Image;
import com.mycompany.myapp.dto.Exam12Member;

@Component
public class Exam12DaoImpl3 implements Exam12Dao{
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DaoImpl3.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int boardInsert(Exam12Board board){	
		//삽입된 행의 수가 리턴된다 (삽입되면 1이 리턴)
		int rows = sqlSessionTemplate.insert("board.insert", board);
	
		return board.getBno();
	}


	
	@Override
	public List<Exam12Board> boardSelectAll() {	
		List<Exam12Board> list = sqlSessionTemplate.selectList("board.selectAll");		
		return list;	
	}
	

	@Override
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", (pageNo-1)*rowsPerPage + 1);
		map.put("endNum", pageNo*rowsPerPage);
		List<Exam12Board> list = sqlSessionTemplate.selectList("board.selectByPage", map);			
		return list;
	}
	
	@Override
	public int boardCountAll() {			
		int count = sqlSessionTemplate.selectOne("board.countAll");
		return count;
	}

	@Override
	public Exam12Board boardSelectByBno(int bno) {		
		Exam12Board board = sqlSessionTemplate.selectOne("board.selectByBno", bno);			
		return board;
	}
	
	@Override
	public void boardUpdateBhitcount(int bno, int bhitcount) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bhitcount", bhitcount);
		map.put("bno", bno);
		sqlSessionTemplate.update("board.updateBhitcount", map);
	}
	
	@Override
	public void boardUpdate(Exam12Board board) {		
		sqlSessionTemplate.update("board.update", board);
	}
	
	@Override
	public void boardDelete(int bno) {		
		sqlSessionTemplate.delete("board.delete", bno);			
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String memberInsert(Exam12Member member) {
		int rows = sqlSessionTemplate.insert("member.insert", member);
		
		return member.getMid();		
	}
	
	@Override
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", (pageNo-1)*rowsPerPage + 1);
		map.put("endNum", pageNo*rowsPerPage);
		List<Exam12Member> list = sqlSessionTemplate.selectList("member.selectByPage", map);			
		return list;		
	}
			
	
	
	@Override
	public int memberCountAll() {

		int count = sqlSessionTemplate.selectOne("member.countAll");
		return count;
		
	}
	
	
	@Override
	public Exam12Member memberSelectByMid(String mid) {

		Exam12Member member = sqlSessionTemplate.selectOne("member.selectByMid", mid);			
		return member;
	}	
	
	
	@Override
	public void memberUpdate(Exam12Member member) {

		sqlSessionTemplate.update("member.update", member);
	}
	
	@Override
	public void memberDelete(String mid) {
		
		sqlSessionTemplate.delete("member.delete", mid);	
			
		
	}
	
	@Override
	public String memberDownload(String mid) {
		
		String msavedfilename = sqlSessionTemplate.selectOne("member.download", mid);
		return msavedfilename;
		
		
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public int imageInsert(Exam12Image image){	
		int no = -1;		
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "user02", "java12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "insert into image ";
			sql += "(no, title, content, writer, filename, password, day) ";
			sql += "values ";
			sql += "(image_no_seq.nextval, ?, ?, ?, ?, ?, sysdate)";			
			
			
			//오라클일 경우 Sequence 외부 객체로 자동 증가값을 얻기 때문에 다음과 같이 지정			
			PreparedStatement pstmt =conn.prepareStatement(sql);			
			pstmt.setString(1, image.getTitle());
			pstmt.setString(2, image.getContent());
			pstmt.setString(3, image.getWriter());			
			pstmt.setString(4, image.getFilename());
			pstmt.setString(5, image.getPassword());
			
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();
			no = rs.getInt(1);
			pstmt.close();
			
						
			LOGGER.info("행 추가 성공");
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			//연결 끊기
			try {
				conn.close();
				LOGGER.info("연결 끊김");
			} catch (SQLException e) {}			
		}
		return no;
	}


	




	
	@Override
	public List<Exam12Image> imageSelectAll() {
		List<Exam12Image> list = new ArrayList<>();
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "user02", "java12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "select no, title, content, writer, hitcount, filename, password, day";
			sql += "from image ";
			sql += "order by no desc ";
								
			
			//SQL문을 전송해서 실행
			PreparedStatement pstmt =conn.prepareStatement(sql);			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Exam12Image image = new Exam12Image();
				
				image.setNo(rs.getInt("no"));
				image.setTitle(rs.getString("title"));
				image.setContent(rs.getString("content"));
				image.setWriter(rs.getString("writer"));
				image.setHitcount(rs.getInt("hitcount"));
				image.setFilename(rs.getString("filename"));
				image.setPassword(rs.getString("password"));
				image.setDay(rs.getDate("day"));
				list.add(image);				
			}
			rs.close();
			pstmt.close();
			
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			//연결 끊기
			try {
				conn.close();
				LOGGER.info("연결 끊김");
			} catch (SQLException e) {}			
		}
		return list;
	}

	@Override
	public List<Exam12Image> imageSelectPage(int pageNo, int rowsPerPage) {
		List<Exam12Image> list = new ArrayList<>();
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "user02", "java12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "select * ";
			sql +="from ( ";
			sql +="  select rownum as r, no, title, content, writer, hitcount, filename, password, day ";
			sql +="  from (";
			sql +="    select no, title, content, writer, hitcount, filename, password, day from image order by no desc ";
			sql +="  ) ";
			sql +="  where rownum<=? ";
			sql +=") ";
			sql +="where r>=? ";
								
			
			//SQL문을 전송해서 실행
			PreparedStatement pstmt =conn.prepareStatement(sql);
			
			pstmt.setInt(1, pageNo*rowsPerPage);
			pstmt.setInt(2, (pageNo-1)*rowsPerPage+1);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Exam12Image image = new Exam12Image();
				
				image.setNo(rs.getInt("no"));
				image.setTitle(rs.getString("title"));
				image.setContent(rs.getString("content"));
				image.setWriter(rs.getString("writer"));
				image.setHitcount(rs.getInt("hitcount"));
				image.setFilename(rs.getString("filename"));
				image.setPassword(rs.getString("password"));
				image.setDay(rs.getDate("day"));
				list.add(image);				
			}
			rs.close();
			pstmt.close();
			
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			//연결 끊기
			try {
				conn.close();
				LOGGER.info("연결 끊김");
			} catch (SQLException e) {}			
		}
		return list;
	}
	
	@Override
	public int imageCountAll() {
		int count=0;
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "user02", "java12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "select count(*) from image";
			
			//SQL문을 전송해서 실행
			PreparedStatement pstmt =conn.prepareStatement(sql);			
			ResultSet rs = pstmt.executeQuery();			
			rs.next();
			count = rs.getInt(1);
			rs.close();
			pstmt.close();
			
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			//연결 끊기
			try {
				conn.close();
				LOGGER.info("연결 끊김");
			} catch (SQLException e) {}			
		}
		return count;
	}

	@Override
	public Exam12Image imageSelectByNo(int no) {
		Exam12Image image = null;
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "user02", "java12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "select * from image where no=?";
			
			//SQL문을 전송해서 실행
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();			
			if(rs.next()){
				image = new Exam12Image();
				
				image.setNo(rs.getInt("no"));
				image.setTitle(rs.getString("title"));
				image.setContent(rs.getString("content"));
				image.setWriter(rs.getString("writer"));
				image.setHitcount(rs.getInt("hitcount"));
				image.setFilename(rs.getString("filename"));
				image.setPassword(rs.getString("password"));
				image.setDay(rs.getDate("day"));	
			}			
			rs.close();
			pstmt.close();
			
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			//연결 끊기
			try {
				conn.close();
				LOGGER.info("연결 끊김");
			} catch (SQLException e) {}			
		}
		return image;
	}
	
	@Override
	public void imageUpdateHitcount(int no, int hitcount) {
		
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "user02", "java12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "update image set hitcount=? where no=?";
			
			//SQL문을 전송해서 실행
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, hitcount);
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
			pstmt.close();
			
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			//연결 끊기
			try {
				conn.close();
				LOGGER.info("연결 끊김");
			} catch (SQLException e) {}			
		}
	}
	
	@Override
	public void imageUpdate(Exam12Image image) {
		
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "user02", "java12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql;
			if(image.getFilename()!= null){
				sql = "update image set title=?, content=?, filename=?, password=? where no=?";
			} else {
				sql = "update image set title=?, content=?, password=? where no=?";
			}
			//SQL문을 전송해서 실행
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, image.getTitle());
			pstmt.setString(2, image.getContent());
			
			
			if(image.getFilename()!= null){
				pstmt.setString(3, image.getFilename());
				pstmt.setString(4, image.getPassword());
				pstmt.setInt(5, image.getNo());				
			} else{
				pstmt.setString(3, image.getPassword());
				pstmt.setInt(4, image.getNo());
			}
			pstmt.executeUpdate();
			pstmt.close();
			
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			//연결 끊기
			try {
				conn.close();
				LOGGER.info("연결 끊김");
			} catch (SQLException e) {}			
		}
	}
	
	@Override
	public void imageDelete(int no) {
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "user02", "java12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "delete from image where no=?";
			
			//SQL문을 전송해서 실행
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			pstmt.close();
			
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			//연결 끊기
			try {
				conn.close();
				LOGGER.info("연결 끊김");
			} catch (SQLException e) {}			
		}
		
	}
	@Override
	public String imageDownload(int no) {
		String filename="";
		Connection conn = null;
		
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "user02", "java12345");
			//LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "select filename from image where no=?";
			
			//SQL문을 전송해서 실행
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();	
			
			if(rs.next()){
				filename = rs.getString("filename");
			}
			
			pstmt.executeUpdate();
			pstmt.close();
			
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();	
		}
		 finally {
			//연결 끊기
			try {
				conn.close();
				//LOGGER.info("연결 끊김");
			} catch (SQLException e) {}			
		}
		return filename;		
		
	}
	
			
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	


}
