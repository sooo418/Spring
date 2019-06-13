package spring;

import spring.biz.user.dao.UserDAO;
import spring.biz.user.dao.UserDAO_JDBC;
import spring.biz.user.dao.UserDAO_MyBatis;
import spring.biz.user.service.UserService;
import spring.biz.user.service.UserServiceImpl;
import spring.biz.user.vo.UserVO;

public class Test02_UserService {

	public static void main(String[] args) {
		
		//UserDAO_JDBC dao = new UserDAO_JDBC();
		UserDAO dao = new UserDAO_JDBC();
		//인터페이스를 사용한 다형성으로 결합도를 조금 낮출 수 있다.
		UserService service = new UserServiceImpl(dao);
		System.out.println(service.login("admin", "1234"));
		System.out.println(service.login("admin", "a1234"));
		System.out.println("-------------------------------");
		for(UserVO vo : service.getUserList()) {
			System.out.println(vo);
		}
	}

}
