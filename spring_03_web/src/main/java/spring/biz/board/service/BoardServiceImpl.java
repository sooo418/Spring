package spring.biz.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import spring.biz.board.dao.BoardDAO;
import spring.biz.board.vo.BoardVO;
import spring.biz.user.vo.UserVO;

@Service("bs")
public class BoardServiceImpl implements BoardService{
	
	@Resource(name = "bdm")
	BoardDAO dao;

	public BoardServiceImpl() {
	}

	
	public BoardServiceImpl(BoardDAO dao) {
		this.dao = dao;
	}


	public BoardDAO getDao() {
		return dao;
	}


	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}


	@Override
	public UserVO memberCheck(String userid, String userpwd) {
		return dao.memberCheck(userid, userpwd);
	}

	@Override
	public int addPost(BoardVO post) {
		return dao.addPost(post);
	}
	
	@Override
	public BoardVO getBoard(int seq) {
		return dao.getBoard(seq);
	}

	@Override
	public int removePost(int seq) {
		return dao.removePost(seq);
	}

	@Override
	public int updatePost(BoardVO post) {
		return dao.updatePost(post);
	}

	@Override
	public List<BoardVO> getPostList() {
		return dao.getPostList();
	}

	@Override
	public List<BoardVO> searchPost(String condition, String keyword) {
		return dao.searchPost(condition, keyword);
	}


}
