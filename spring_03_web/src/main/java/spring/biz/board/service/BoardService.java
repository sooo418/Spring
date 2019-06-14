package spring.biz.board.service;

import java.util.List;

import spring.biz.board.vo.BoardVO;
import spring.biz.user.vo.UserVO;

public interface BoardService {
	UserVO memberCheck(String userid, String userpwd);
	int addPost(BoardVO post);
	BoardVO getBoard(int seq);
	int removePost(int seq);
	int updatePost(BoardVO post);
	List<BoardVO> getPostList();
	List<BoardVO> searchPost(String condition, String keyword);
}
