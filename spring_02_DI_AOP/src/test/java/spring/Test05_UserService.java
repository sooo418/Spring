package spring;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.biz.user.dao.UserDAO;
import spring.biz.user.dao.UserDAO_JDBC;
import spring.biz.user.dao.UserDAO_MyBatis;
import spring.biz.user.service.UserService;
import spring.biz.user.service.UserServiceImpl;
import spring.biz.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test05_UserService {
	
	@Autowired
	UserService service;
	
	 
	//@Test
	public void login() {
		System.out.println(service.login("admin", "a1234"));
	}
	@Test
	public void list() {
		for(UserVO vo : service.getUserList()) {
			System.out.println(vo);
		}
	}
	//@Test
	public void add() {
		UserVO user = new UserVO();
		user.setUserid("haneul");
		user.setUsername("하길동");
		user.setUserpwd("h1234");
		user.setPhone("010-2225-3333");
		user.setEmail("kim.naver.com");
		user.setAddress("멀티캠퍼스");
		int row = service.addUser(user);
		System.out.println("insert => "+row);
	}
 
	//@Test
	public void update() {
		UserVO user = service.getUser("sssss");
		user.setUserpwd("5555");
		//DAO_JDBC의 updateUser함수에 pwd는 sql문에 존재하지않기 때문에 바뀌지 않는다.
		user.setPhone("010-5555-4444");
		int row = service.updateUser(user);
		System.out.println("update    "+row);
	}
	//@Test
	public void getUser() {
		System.out.println(service.getUser("haneul"));
	}
	//@Test
	public void searchUser() {
		for(UserVO vo : service.searchUser("email", "naver")) {
			System.out.println(vo);
		}
	}
	//@Test
	public void removeUser() {
		int row = service.removeUser("scott");
		System.out.println("removeUser   "+row);
	}
	
}
