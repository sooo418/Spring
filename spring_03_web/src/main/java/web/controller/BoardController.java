package web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.biz.board.service.BoardService;
import spring.biz.board.vo.BoardVO;
import spring.biz.user.vo.UserVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@RequestMapping(value = "/board_login.do", method = RequestMethod.GET)
	public String login() {
		
		return "board_login";
	}
	@RequestMapping(value = "/board_login.do", method = RequestMethod.POST)
	public String loginProc(UserVO vo, HttpServletRequest request) {
		UserVO user = service.memberCheck(vo.getUserid(), vo.getUserpwd());
		if(user != null) {
			request.getSession().setAttribute("User", user);
			request.getSession().setAttribute("login", user);
			return "redirect:board_index.jsp";
		}else {
			request.setAttribute("msg", " 로그인 정보를 다시 입력해주세요");
			return "board_login";
		}
	}

@RequestMapping("/board_logout.do")
public String logout(HttpServletRequest request) {
	request.getSession().invalidate();
	request.setAttribute("msg", "로그아웃되었습니다.");
	return "board_login";
	}
	
	
	@RequestMapping("/board/list.do")
	public ModelAndView getBoardList() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("boards", service.getPostList());
		mav.setViewName("board/board_list");
		return mav;
	}
	
	@RequestMapping(value = "/board/add.do", method = RequestMethod.GET) 
	public String addBoard() { 
		return "board/board_write"; 
	}
	
	@RequestMapping(value = "/board/add.do", method = RequestMethod.POST) 
	public String addBoardProc(BoardVO post,HttpServletRequest request) { 
		int row=0;
		row=service.addPost(post);
		return "redirect:/board/list.do"; 
	}
 
	@RequestMapping("/board/view.do") 
	public ModelAndView	getView(int seq) { 
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("board", service.getBoard(seq));
		mav.setViewName("board/board_view"); 
		return mav; 
		}
	@RequestMapping("/board/remove.do") 
	public String removeBoard(int seq) {
		service.removePost(seq);
		return "redirect:/board/list.do"; 
	}
	@RequestMapping("/board/modify.do") 
	public ModelAndView modify(int seq) { 
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("board", service.getBoard(seq));
		mav.setViewName("board/board_modify"); 
		return mav; 
	}
	@RequestMapping("/board/update.do") 
	//public ModelAndView update(@ModelAttribute("user") UserVO vo) { 
	public ModelAndView update(BoardVO post) { 
		System.out.println(post); 
		ModelAndView mav = new ModelAndView();
		service.updatePost(post); 
		mav.addObject("board", service.getBoard(post.getSeq()));
		mav.setViewName("board/board_view"); 
		return mav; 
	}
	@RequestMapping("/board/search.do") 
	public ModelAndView search(String searchCondition, String searchKeyword) { 
		ModelAndView mav = new ModelAndView();
		mav.addObject("boards", service.searchPost(searchCondition, searchKeyword));
		mav.setViewName("board/board_list"); 
		return mav; 
		}
			
	@ExceptionHandler(Exception.class) 
	public String Ex(Exception exception,Model model) { 
		model.addAttribute("exception", exception); 
		return "board_error"; 
	}
	
}
