package com.mycompany.myapp.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Image;
import com.mycompany.myapp.dto.Exam12Member;

@Component
public class Exam12DaoImpl implements Exam12Dao{
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DaoImpl.class);
	
	@Override
	public int boardInsert(Exam12Board board){	
		int bno = -1;
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "insert into board ";
			sql += "(bno, btitle, bcontent, bwriter, bdate, bpassword, bhitcount, boriginalfilename, bsavedfilename, bfilecontent) ";
			sql += "values ";
			sql += "(board_bno_seq.nextval, ?, ?, ?, sysdate, ?, 0, ?, ?, ?)";
			//SQL 문을 전송해서 실행
			//테이블 정의시 컬럼의 속성으로 자동 증가를 지정할 수 있는 DB일 경우(MySQL, MS SQL)
			//PreparedStatement pstmt =conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			//오라클일 경우 Sequence 외부 객체로 자동 증가값을 얻기 때문에 다음과 같이 지정
			PreparedStatement pstmt =conn.prepareStatement(sql, new String[]{"bno"});
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBwriter());
			pstmt.setString(4, board.getBpassword());
			pstmt.setString(5, board.getBoriginalfilename());
			pstmt.setString(6, board.getBsavedfilename());
			pstmt.setString(7, board.getBfilecontent());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();
			bno = rs.getInt(1);
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
		return bno;
	}


	




	
	@Override
	public List<Exam12Board> boardSelectAll() {
		List<Exam12Board> list = new ArrayList<>();
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "select bno, btitle, bwriter, bdate, bhitcount ";
			sql += "from board ";
			sql += "order by bno desc ";
								
			
			//SQL문을 전송해서 실행
			PreparedStatement pstmt =conn.prepareStatement(sql);			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Exam12Board board = new Exam12Board();
				
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString(3));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				list.add(board);				
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
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage) {
		List<Exam12Board> list = new ArrayList<>();
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "select * ";
			sql +="from ( ";
			sql +="  select rownum as r, bno, btitle, bwriter,  bdate, bhitcount ";
			sql +="  from (";
			sql +="    select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc ";
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
				Exam12Board board = new Exam12Board();
				
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				list.add(board);				
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
	public int boardCountAll() {
		int count=0;
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "select count(*) from board";
			
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
	public Exam12Board boardSelectByBno(int bno) {
		Exam12Board board = null;
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "select * from board where bno=?";
			
			//SQL문을 전송해서 실행
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery();			
			if(rs.next()){
				board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBpassword(rs.getString("bpassword"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBoriginalfilename(rs.getString("boriginalfilename"));
				board.setBsavedfilename(rs.getString("bsavedfilename"));
				board.setBfilecontent(rs.getString("bfilecontent"));
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
		return board;
	}
	
	@Override
	public void boardUpdateBhitcount(int bno, int bhitcount) {
		
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "update board set bhitcount=? where bno=?";
			
			//SQL문을 전송해서 실행
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, bhitcount);
			pstmt.setInt(2, bno);
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
	public void boardUpdate(Exam12Board board) {
		
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql;
			if(board.getBoriginalfilename()!= null){
				sql = "update board set btitle=?, bcontent=?, bpassword=?, bdate=sysdate, boriginalfilename=?, bsavedfilename=?, bfilecontent=? where bno=?";
			} else {
				sql = "update board set btitle=?, bcontent=?, bpassword=?, bdate=sysdate where bno=?";
			}
			//SQL문을 전송해서 실행
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBpassword());
			if(board.getBoriginalfilename()!= null){
				pstmt.setString(4, board.getBoriginalfilename());
				pstmt.setString(5, board.getBsavedfilename());
				pstmt.setString(6, board.getBfilecontent());
				pstmt.setInt(7, board.getBno());
			} else{
				pstmt.setInt(4, board.getBno());
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
	public void boardDelete(int bno) {
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "delete from board where bno=?";
			
			//SQL문을 전송해서 실행
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
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
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String memberInsert(Exam12Member member) {
		String mid = null;
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "insert into member ";
			sql += "(mid, mname, mpassword, mdate, mtel, memail, mage, maddress, moriginalfilename, msavedfilename, mfilecontent) ";
			sql += "values ";
			sql += "(?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?)";			
			
			
			//오라클일 경우 Sequence 외부 객체로 자동 증가값을 얻기 때문에 다음과 같이 지정
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMname());
			pstmt.setString(3, member.getMpassword());
			pstmt.setString(4, member.getMtel());
			pstmt.setString(5, member.getMemail());
			pstmt.setInt(6, member.getMage());
			pstmt.setString(7, member.getMaddress());
			pstmt.setString(8, member.getMoriginalfilename());
			pstmt.setString(9, member.getMsavedfilename());
			pstmt.setString(10, member.getMfilecontent());
			pstmt.executeUpdate();
			pstmt.close();
			
			mid = member.getMid();			
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
		return mid;
	}
	
	@Override
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage) {
		List<Exam12Member> list = new ArrayList<>();
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "select * ";
			sql +="from ( ";
			sql +="  select rownum as r, mid, mname, mpassword, mdate, mtel, memail, mage, maddress ";
			sql +="  from (";
			sql +="    select mid, mname, mpassword, mdate, mtel, memail, mage, maddress from member order by mage desc ";
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
				Exam12Member member = new Exam12Member();
				
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMdate(rs.getDate("mdate"));
				member.setMtel(rs.getString("mtel"));
				member.setMemail(rs.getString("memail"));
				member.setMage(rs.getInt("mage"));
				member.setMaddress(rs.getString("maddress"));
				list.add(member);				
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
	public int memberCountAll() {
		int count=0;
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "select count(*) from member";
			
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
	public Exam12Member memberSelectByMid(String mid) {
		Exam12Member member = null;
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "select * from member where mid=?";
			
			//SQL문을 전송해서 실행
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			ResultSet rs = pstmt.executeQuery();			
			if(rs.next()){
				member = new Exam12Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMdate(rs.getDate("mdate"));
				member.setMtel(rs.getString("mtel"));
				member.setMemail(rs.getString("memail"));
				member.setMage(rs.getInt("mage"));
				member.setMaddress(rs.getString("maddress"));
				member.setMoriginalfilename(rs.getString("moriginalfilename"));
				member.setMsavedfilename(rs.getString("msavedfilename"));
				member.setMfilecontent(rs.getString("mfilecontent"));
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
		return member;
	}
	
	
	
	@Override
	public void memberUpdate(Exam12Member member) {
		
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql;
			if(member.getMoriginalfilename()!= null){
				sql = "update member set mpassword=?, mtel=?, memail=?, maddress=?, moriginalfilename=?, msavedfilename=?, mfilecontent=? where mid=?";
			} else {
				sql = "update member set mpassword=?, mtel=?, memail=?, maddress=? where mid=?";
			}
			//SQL문을 전송해서 실행
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, member.getMpassword());
			pstmt.setString(2, member.getMtel());
			pstmt.setString(3, member.getMemail());
			pstmt.setString(4, member.getMaddress());
			if(member.getMoriginalfilename()!= null){
				pstmt.setString(5, member.getMoriginalfilename());
				pstmt.setString(6, member.getMsavedfilename());
				pstmt.setString(7, member.getMfilecontent());
				pstmt.setString(8, member.getMid());
			} else{
				pstmt.setString(5, member.getMid());
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
	public void memberDelete(String mid) {
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "delete from member where mid=?";
			
			//SQL문을 전송해서 실행
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, mid);
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
	public String memberDownload(String mid) {
		String msavedfilename="";
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "select msavedfilename from member where mid=?";
			
			//SQL문을 전송해서 실행
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			ResultSet rs = pstmt.executeQuery();			
			if(rs.next()){
				msavedfilename = rs.getString("msavedfilename");
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
			sql += "(no, title, content, writer, hitcount, filename, password, day) ";
			sql += "values ";
			sql += "(?, ?, ?, ?, ?, ?, ?, sysdate)";			
			
			
			//오라클일 경우 Sequence 외부 객체로 자동 증가값을 얻기 때문에 다음과 같이 지정
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, image.getNo());
			pstmt.setString(2, image.getTitle());
			pstmt.setString(3, image.getContent());
			pstmt.setString(4, image.getWriter());
			pstmt.setInt(5, image.getHitcount());
			pstmt.setString(6, image.getFilename());
			pstmt.setString(7, image.getPassword());
			
			pstmt.executeUpdate();
			pstmt.close();
			
			no = image.getNo();			
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
			LOGGER.info("연결 성공");
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
				LOGGER.info("연결 끊김");
			} catch (SQLException e) {}			
		}
		return filename;
		
		
	}
	
		
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args){
		/*
		Exam12DaoImpl test = new Exam12DaoImpl();
		for(int i=1; i<=100; i++){			
			Exam12Member member = new Exam12Member();
			member.setMid("id"+i);			
			member.setMname("이름"+i);
			member.setMpassword("12345");
			member.setMtel("010-0000-0000");
			member.setMemail("aaa@naver.com");
			member.setMage(i);
			member.setMaddress("서울");
			member.setMoriginalfilename("a.png");
			member.setMsavedfilename("b.png");
			member.setMfilecontent("image");			
			test.memberInsert(member);
		}	
		*/
		Exam12DaoImpl test = new Exam12DaoImpl();
		for(int i=1; i<=20; i++){
			Exam12Image image = new Exam12Image();
			
			image.setNo(i);
			image.setTitle("title"+i);
			image.setContent("content"+i);
			image.setWriter("writer"+i);
			image.setHitcount(0);
			image.setFilename("default.png");
			image.setPassword("12345");
			test.imageInsert(image);
			
		}
		
	}



}
