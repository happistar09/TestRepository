package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Image;
import com.mycompany.myapp.dto.Exam12Member;

@Component
public class Exam12DaoImpl2 implements Exam12Dao{
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DaoImpl2.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int boardInsert(Exam12Board board){	
		

		final String sql = "insert into board " +
							"(bno, btitle, bcontent, bwriter, bdate, bpassword, bhitcount, boriginalfilename, bsavedfilename, bfilecontent) "+
							"values " +
							"(board_bno_seq.nextval, ?, ?, ?, sysdate, ?, 0, ?, ?, ?)";
			
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt =conn.prepareStatement(sql, new String[]{"bno"});
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.setString(4, board.getBpassword());
				pstmt.setString(5, board.getBoriginalfilename());
				pstmt.setString(6, board.getBsavedfilename());
				pstmt.setString(7, board.getBfilecontent());
				return pstmt;
			}
		};
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(psc,keyHolder);
		int bno = keyHolder.getKey().intValue();
		
		LOGGER.info(String.valueOf(bno));
		return bno;
	}


	
	@Override
	public List<Exam12Board> boardSelectAll() {		
		
		String sql = "select bno, btitle, bwriter, bdate, bhitcount ";
		sql += "from board ";
		sql += "order by bno desc ";
		
		RowMapper<Exam12Board> rowMapper = new RowMapper<Exam12Board>() {
			@Override
			public Exam12Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Exam12Board board = new Exam12Board();				
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString(3));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				return board;
			}
		};
		List<Exam12Board> list = jdbcTemplate.query(sql, rowMapper);	
		
		return list;
	}
	

	@Override
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage) {
		
		String sql = "select * ";
		sql +="from ( ";
		sql +="  select rownum as r, bno, btitle, bwriter,  bdate, bhitcount ";
		sql +="  from (";
		sql +="    select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc ";
		sql +="  ) ";
		sql +="  where rownum<=? ";
		sql +=") ";
		sql +="where r>=? ";
		
		Object[] args = {(pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage+1)};
		RowMapper<Exam12Board> rowMapper = new RowMapper<Exam12Board>() {
			@Override
			public Exam12Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Exam12Board board = new Exam12Board();				
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString(3));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				return board;
			}
		};
		List<Exam12Board> list = jdbcTemplate.query(sql, args, rowMapper);			
			
		return list;
	}
	
	@Override
	public int boardCountAll() {
			
		String sql = "select count(*) from board";		
		int count = (int) jdbcTemplate.queryForObject(sql, Integer.class);			
		return count;
	}

	@Override
	public Exam12Board boardSelectByBno(int bno) {
		
		String sql = "select * from board where bno=?";
		RowMapper<Exam12Board> rowMapper = new RowMapper<Exam12Board>() {
			@Override
			public Exam12Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Exam12Board board = new Exam12Board();				
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBpassword(rs.getString("bpassword"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBoriginalfilename(rs.getString("boriginalfilename"));
				board.setBsavedfilename(rs.getString("bsavedfilename"));
				board.setBfilecontent(rs.getString("bfilecontent"));
				return board;
			}
		};
		Exam12Board board = jdbcTemplate.queryForObject(sql, rowMapper, bno);
			
		return board;
	}
	
	@Override
	public void boardUpdateBhitcount(int bno, int bhitcount) {
		
		
		String sql = "update board set bhitcount=? where bno=?";
			
		jdbcTemplate.update(sql, bhitcount, bno);
	}
	
	@Override
	public void boardUpdate(Exam12Board board) {
		
		
			String sql;
			if(board.getBoriginalfilename()!= null){
				sql = "update board set btitle=?, bcontent=?, bpassword=?, bdate=sysdate, boriginalfilename=?, bsavedfilename=?, bfilecontent=? where bno=?";
				jdbcTemplate.update(sql, board.getBtitle(), board.getBcontent(), board.getBpassword(), board.getBoriginalfilename(), board.getBsavedfilename(), board.getBfilecontent(), board.getBno());
			} else {
				sql = "update board set btitle=?, bcontent=?, bpassword=?, bdate=sysdate where bno=?";
				jdbcTemplate.update(sql, board.getBtitle(), board.getBcontent(), board.getBpassword(), board.getBno());
			}
			
			
	}
	
	@Override
	public void boardDelete(int bno) {
		
			String sql = "delete from board where bno=?";
			
			jdbcTemplate.update(sql, bno);
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String memberInsert(Exam12Member member) {
		
		String sql = "insert into member ";
		sql += "(mid, mname, mpassword, mdate, mtel, memail, mage, maddress, moriginalfilename, msavedfilename, mfilecontent) ";
		sql += "values ";
		sql += "(?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?)";

		jdbcTemplate.update(sql, member.getMid(), member.getMname(), member.getMpassword(), member.getMtel(),
				member.getMemail(), member.getMage(), member.getMaddress(), member.getMoriginalfilename(),
				member.getMsavedfilename(), member.getMfilecontent());
							
			
		return member.getMid();
	}
	
	@Override
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage) {

		String sql = "select * ";
		sql += "from ( ";
		sql += "  select rownum as r, mid, mname, mpassword, mdate, mtel, memail, mage, maddress ";
		sql += "  from (";
		sql += "    select mid, mname, mpassword, mdate, mtel, memail, mage, maddress from member order by mage desc ";
		sql += "  ) ";
		sql += "  where rownum<=? ";
		sql += ") ";
		sql += "where r>=? ";

		Object[] args = { (pageNo * rowsPerPage), ((pageNo - 1) * rowsPerPage + 1) };
		RowMapper<Exam12Member> rowMapper = new RowMapper<Exam12Member>() {
			@Override
			public Exam12Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Exam12Member member = new Exam12Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMdate(rs.getDate("mdate"));
				member.setMtel(rs.getString("mtel"));
				member.setMemail(rs.getString("memail"));
				member.setMage(rs.getInt("mage"));
				member.setMaddress(rs.getString("maddress"));
				return member;
			}
		};
		List<Exam12Member> list = jdbcTemplate.query(sql, args, rowMapper);

		return list;	
	}
		
	
	
	
	@Override
	public int memberCountAll() {

		String sql = "select count(*) from member";

		int count = (int) jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
		
	}
	
	
	@Override
	public Exam12Member memberSelectByMid(String mid) {

		String sql = "select * from member where mid=?";

		RowMapper<Exam12Member> rowMapper = new RowMapper<Exam12Member>() {
			@Override
			public Exam12Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Exam12Member member = new Exam12Member();
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
				return member;
			}
		};
		Exam12Member member = jdbcTemplate.queryForObject(sql, rowMapper, mid);

		return member;
	}	
	
	
	@Override
	public void memberUpdate(Exam12Member member) {

		String sql;
		if (member.getMoriginalfilename() != null) {
			sql = "update member set mpassword=?, mtel=?, memail=?, maddress=?, moriginalfilename=?, msavedfilename=?, mfilecontent=? where mid=?";
			jdbcTemplate.update(sql, member.getMpassword(), member.getMtel(), member.getMemail(), member.getMaddress(),
					member.getMoriginalfilename(), member.getMsavedfilename(), member.getMfilecontent(),
					member.getMid());
		} else {
			sql = "update member set mpassword=?, mtel=?, memail=?, maddress=? where mid=?";
			jdbcTemplate.update(sql, member.getMpassword(), member.getMtel(), member.getMemail(), member.getMaddress(),
					member.getMid());
		}

	}
	
	@Override
	public void memberDelete(String mid) {
		
			String sql = "delete from member where mid=?";
			jdbcTemplate.update(sql, mid);
			
		
	}
	
	@Override
	public String memberDownload(String mid) {
		
			String sql = "select msavedfilename from member where mid=?";
			RowMapper<Exam12Member> rowMapper = new RowMapper<Exam12Member>() {
				@Override
				public Exam12Member mapRow(ResultSet rs, int rowNum) throws SQLException {
					Exam12Member member = new Exam12Member();					
					member.setMsavedfilename(rs.getString("msavedfilename"));				
					return member;
				}
			};
			Exam12Member member = jdbcTemplate.queryForObject(sql, rowMapper, mid);
		return member.getMsavedfilename();
		
		
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
