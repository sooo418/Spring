package spring.biz.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import spring.biz.board.vo.BoardVO;
import spring.biz.user.vo.UserVO;
import util.JDBCUtil;

@Repository("bdj")
public class BoardDAO_JDBC implements BoardDAO{
	private String userid;
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public UserVO memberCheck(String userid, String userpwd) {
		System.out.println("BoardDAO_JDBC 연동");
		String sql ="select * from userinfo where userid=? and userpwd=?";
				
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		UserVO vo = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			//	?	세팅
			ps.setString(1, userid);
			ps.setString(2, userpwd);
			
			//	실행
			rs=ps.executeQuery();
			
			//	결과값 핸들링
			while(rs.next()) {
				vo= new UserVO();
				vo.setUserid(rs.getString("userid"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setEmail(rs.getString("email"));
				vo.setUsername(rs.getString("username"));
				vo.setUserpwd(rs.getString("userpwd"));
				setUserid(rs.getString("userid"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		return vo;
	}

	@Override
	public int addPost(BoardVO post) {
		System.out.println("BoardDAO_JDBC 연동");
		String sql ="insert into board (seq, title, content, regdate, cnt, id)"
				+" values ((select nvl(max(seq),0)+1 from board), ?, ?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//	?	세팅
			ps.setInt(1, post.getSeq());
			ps.setString(2, post.getTitle());
			ps.setString(3, post.getContent());
			ps.setString(4, post.getRegdate());
			ps.setInt(5, post.getCnt());
			ps.setString(6,	getUserid());
			
			//	실행
			row = ps.executeUpdate();
			
			//	결과값 핸들링
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		return row;
	}
	
	@Override
	public BoardVO getBoard(int seq) {
		System.out.println("BoardDAO_JDBC 연동");
		
		String sql =
				"select * from board where seq=? and id=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		BoardVO post = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//	?	세팅
			ps.setInt(1, seq);
			ps.setString(2, getUserid());
			
			//	실행
			rs=ps.executeQuery();
				
			//	결과값 핸들링
			while(rs.next()) {
				post = new BoardVO();
				post.setSeq(rs.getInt("seq"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setRegdate(rs.getString("regdate"));
				post.setCnt(rs.getInt("cnt"));
				post.setId(rs.getString("id"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		return post;
	}

	@Override
	public int removePost(int seq) {
		System.out.println("BoardDAO_JDBC 연동");
		String sql ="delete from board where id=? and seq=?";
				
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			//	?	세팅
			ps.setString(1, getUserid());
			ps.setInt(2, seq);
			
			//	실행
			row = ps.executeUpdate();
			
			//	결과값 핸들링
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		return row;
	}

	@Override
	public int updatePost(BoardVO post) {
		System.out.println("BoardDAO_JDBC 연동");
		String sql ="update board set title=?, content=? where id=? and seq=?";
				
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			//	?	세팅
			ps.setString(1, post.getTitle());
			ps.setString(2, post.getContent());
			ps.setString(3, getUserid());
			ps.setInt(4, post.getSeq());
			
			//	실행
			row = ps.executeUpdate();
			
			//	결과값 핸들링
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		return row;
	}

	@Override
	public List<BoardVO> getPostList() {
		System.out.println("BoardDAO_JDBC 연동");
		String sql ="select * from board order by 1";
				
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		BoardVO post = null;
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			//	?	세팅
			
			//	실행
			rs = ps.executeQuery();
			
			//	결과값 핸들링
			while(rs.next()) {
				post = new BoardVO();
				post.setSeq(rs.getInt("seq"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setRegdate(rs.getString("regdate"));
				post.setCnt(rs.getInt("cnt"));
				post.setId(rs.getString("id"));
				list.add(post);
			}
		
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<BoardVO> searchPost(String condition, String keyword) {
		System.out.println("BoardDAO_JDBC 연동");
		String sql ="select * from board where " + condition + " like '%'||?||'%'";
				
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		BoardVO post = null;
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			//	?	세팅
			ps.setString(1, keyword);
			
			//	실행
			rs = ps.executeQuery();
			
			//	결과값 핸들링
			while(rs.next()) {
				post = new BoardVO();
				post.setSeq(rs.getInt("seq"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setRegdate(rs.getString("regdate"));
				post.setCnt(rs.getInt("cnt"));
				post.setId(rs.getString("id"));
				list.add(post);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}


}
