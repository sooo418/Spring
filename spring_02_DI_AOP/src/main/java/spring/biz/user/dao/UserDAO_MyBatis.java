package spring.biz.user.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.biz.user.vo.UserVO;

@Repository("udm")
public class UserDAO_MyBatis implements UserDAO{
	
	@Autowired
	SqlSession sqlSession = null;

	@Override
	public UserVO login(String id, String pw) {
		System.out.println("UserDAO_MyBatis 연동");
		System.out.println("sqlSession => "+sqlSession);
		UserVO vo = new UserVO();
		vo.setUserid(id);
		vo.setUserpwd(pw);
		
		return sqlSession.selectOne("user.login", vo);
	}

	@Override
	public int addUser(UserVO user) {
		System.out.println("UserDAO_MyBatis 연동");
		
		
		return sqlSession.insert("user.add", user);
	}

	@Override
	public UserVO getUser(String userid) {
		System.out.println("UserDAO_MyBatis 연동");
		
		return sqlSession.selectOne("user.getuser", userid);
	}

	@Override
	public List<UserVO> getUserList() {
		System.out.println("UserDAO_MyBatis 연동");
		
		return sqlSession.selectList("user.getuserlist");
	}

	@Override
	public int updateUser(UserVO user) {
		System.out.println("UserDAO_MyBatis 연동");
		return sqlSession.update("user.update", user);
	}

	@Override
	public int removeUser(String userid) {
		System.out.println("UserDAO_MyBatis 연동");
		return sqlSession.delete("user.remove", userid);
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(condition, keyword);
		
		return sqlSession.selectList("user.search", map);
	}


	
}
