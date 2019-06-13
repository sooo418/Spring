package spring.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.biz.board.vo.BoardVO;
import spring.biz.user.vo.UserVO;

@Repository("bdm")
public class BoardDAO_MyBatis implements BoardDAO{
	@Autowired
	SqlSession sqlSession = null;
	
	private String userid;
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Override
	public UserVO memberCheck(String userid, String userpwd) {
		System.out.println("BoardDAO_MyBatis 연동");
		UserVO user = new UserVO();
		user.setUserid(userid);
		user.setUserpwd(userpwd);
		setUserid(userid);
		return sqlSession.selectOne("board.membercheck", user);
	}

	@Override
	public int addPost(BoardVO post) {
		System.out.println("BoardDAO_MyBatis 연동");
		post.setId(getUserid());
		return sqlSession.insert("board.add", post);
	}
	
	@Override
	public BoardVO getBoard(int seq) {
		System.out.println("BoardDAO_MyBatis 연동");
		return sqlSession.selectOne("board.getboard", seq);
	}

	@Override
	public int removePost(int seq) {
		System.out.println("BoardDAO_MyBatis 연동");
		BoardVO post = new BoardVO();
		post.setSeq(seq);
		post.setId(getUserid());
		return sqlSession.delete("board.remove", post);
	}

	@Override
	public int updatePost(BoardVO post) {
		System.out.println("BoardDAO_MyBatis 연동");
		return sqlSession.update("board.update", post);
	}

	@Override
	public List<BoardVO> getPostList() {
		System.out.println("BoardDAO_MyBatis 연동");
		return sqlSession.selectList("board.getpostlist");
	}

	@Override
	public List<BoardVO> searchPost(String condition, String keyword) {
		System.out.println("BoardDAO_MyBatis 연동");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(condition, keyword);
		return sqlSession.selectList("board.search", map);
	}

}
