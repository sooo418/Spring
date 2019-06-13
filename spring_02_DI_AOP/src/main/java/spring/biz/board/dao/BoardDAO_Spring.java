package spring.biz.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.biz.board.vo.BoardVO;
import spring.biz.user.vo.UserVO;

@Repository("bds")
public class BoardDAO_Spring implements BoardDAO{
	
	@Autowired
	private JdbcTemplate template;
	
	private String userid;
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	BoardDAO_Spring(){	}

	@Override
	public UserVO memberCheck(String userid, String userpwd) {
		System.out.println("BoardDAO_JDBC 연동");
		System.out.println("JdbcTemplate ->" + template);
		
		String sql ="select * from userinfo where userid=? and userpwd=?";
		UserVO user = null;
		
		try {
			user = template.queryForObject(sql,
									new Object[] {userid, userpwd},
									new UserRowMapper());
			setUserid(userid);
		} catch (Exception e) {		}
		return user;
	}

	@Override
	public int addPost(BoardVO post) {
		System.out.println("BoardDAO_JDBC 연동");
		System.out.println("JdbcTemplate ->" + template);
		
		String sql ="insert into board (seq, title, content, regdate, cnt, id)"
				+" values ((select nvl(max(seq),0)+1 from board), ?, ?, ?, ?, ?)";
		
		return template.update(sql,
								new Object[] {
										post.getTitle(),
										post.getContent(),
										post.getRegdate(),
										post.getCnt(),
										getUserid()
								});
	}
	
	@Override
	public BoardVO getBoard(int seq) {
		System.out.println("BoardDAO_JDBC 연동");
		System.out.println("JdbcTemplate ->" + template);
		
		String sql ="select * from board where seq=?";
		BoardVO post = null;
		try {
			post = template.queryForObject(sql, 
								new Object[] {seq},
								new BoardRowMapper());
		} catch (Exception e) {
		}
		return post;
	}
	
	@Override
	public int removePost(int seq) {
		System.out.println("BoardDAO_JDBC 연동");
		System.out.println("JdbcTemplate ->" + template);
		
		String sql ="delete from board where id=? and seq=?";
		System.out.println(getUserid());
		return template.update(sql,
							new Object[] {getUserid(), seq});
	}

	@Override
	public int updatePost(BoardVO post) {
		System.out.println("BoardDAO_JDBC 연동");
		System.out.println("JdbcTemplate ->" + template);
		
		String sql ="update board set title=?, content=? where id=? and seq=?";
		return template.update(sql,
								new Object[] {
										post.getTitle(),
										post.getContent(),
										getUserid(),
										post.getSeq()
								});
	}

	@Override
	public List<BoardVO> getPostList() {
		System.out.println("BoardDAO_JDBC 연동");
		System.out.println("JdbcTemplate ->" + template);
		
		String sql ="select * from board order by 1";
		return template.query(sql, 
							new BoardRowMapper());
	}

	@Override
	public List<BoardVO> searchPost(String condition, String keyword) {
		System.out.println("BoardDAO_JDBC 연동");
		System.out.println("JdbcTemplate ->" + template);
		
		String sql ="select * from board where " + condition + " like '%'||?||'%'";
		
		return template.query(sql, 
							new Object[] {keyword},
							new BoardRowMapper());
	}

}
class UserRowMapper implements RowMapper<UserVO>{

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO user = new UserVO();
		user.setUserid(rs.getString("userid"));
		user.setUsername(rs.getString("username"));
		user.setEmail(rs.getString("email"));
		user.setPhone(rs.getString("phone"));
		user.setAddress(rs.getString("address"));
		user.setUserpwd(rs.getString("userpwd"));
		return user;
	}
	
}

class BoardRowMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO post = new BoardVO();
		post.setSeq(rs.getInt("seq"));
		post.setTitle(rs.getString("title"));
		post.setContent(rs.getString("content"));
		post.setRegdate(rs.getString("regdate"));
		post.setCnt(rs.getInt("cnt"));
		post.setId(rs.getString("id"));
		return post;
	}
	
}