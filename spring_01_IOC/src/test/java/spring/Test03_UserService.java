package spring;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import spring.biz.user.dao.UserDAO;
import spring.biz.user.dao.UserDAO_JDBC;
import spring.biz.user.dao.UserDAO_MyBatis;
import spring.biz.user.service.UserService;
import spring.biz.user.service.UserServiceImpl;
import spring.biz.user.vo.UserVO;

public class Test03_UserService {
	
	UserService service;
	
	@Before
	public void setUpBeforeClass() throws Exception {
		UserDAO dao = new UserDAO_JDBC();
		service = new UserServiceImpl(dao);
	}

	//@Test
	public void login() {
		System.out.println(service.login("admin", "1234"));
	}
	//@Test
	public void list() {
		for(UserVO vo : service.getUserList()) {
			System.out.println(vo);
		}
	}
	//@Test
	public void add() {
		UserVO user = new UserVO();
		user.setUserid("sssss");
		user.setUsername("홍길동");
		user.setUserpwd("1234");
		user.setPhone("010-1111-1111");
		user.setEmail("hong.naver.com");
		user.setAddress("멀티캠퍼스");
		int row = service.addUser(user);
		System.out.println("insert => "+row);
	}

	//@Test
	public void update() {
		UserVO user = service.getUser("sssss");
		user.setUserpwd("8989");
		//DAO_JDBC의 updateUser함수에 pwd는 sql문에 존재하지않기 때문에 바뀌지 않는다.
		user.setPhone("010-2222-2222");
		int row = service.updateUser(user);
		System.out.println("update    "+row);
	}
	//@Test
	public void getUser() {
		System.out.println(service.getUser("sssss"));
	}
	//@Test
	public void searchUser() {
		for(UserVO vo : service.searchUser("email", "naver")) {
			System.out.println(vo);
		}
	}
	@Test
	public void removeUser() {
		int row = service.removeUser("scott");
		System.out.println("removeUser   "+row);
	}
	
}
