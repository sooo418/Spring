package spring;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.biz.board.service.BoardService;
import spring.biz.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test01_BoardService {
	
	@Autowired
	BoardService service;
	
	//@Test
	public void memberCheck() {
		System.out.println(service.memberCheck("admin", "a1234"));
	}
	//@Test
	public void add() {
		service.memberCheck("haneul", "h1234");
		BoardVO post = new BoardVO();
		post.setTitle("방가방가");
		post.setContent("하이하이");
		post.setRegdate("2019-06-10");
		int row=service.addPost(post);
		System.out.println("insert  "+row);
	}
	//@Test
	public void getboard() {
		System.out.println(service.getBoard(5));
	}
	//@Test
	public void remove() {
		service.memberCheck("haneul", "h1234");
		int row = service.removePost(7);
		System.out.println("remove  "+row);
	}
	//@Test
	public void update() {
		service.memberCheck("haneul", "h1234");
		BoardVO post = service.getBoard(4);
		System.out.println(post);
		post.setTitle("호이");
		post.setContent("잘가");
		int row = service.updatePost(post);
		System.out.println("update  "+row);
	}
	//@Test
	public void List() {
		List<BoardVO> list = service.getPostList();
		list.forEach(i->System.out.println(i));
		//for(BoardVO post : service.getPostList()) {
			//System.out.println(post);
		//}
	}
	@Test
	public void searchBoard() {
		for(BoardVO post : service.searchPost("id", "han")) {
			System.out.println(post);
		}
	}
}
