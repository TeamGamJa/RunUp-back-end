package team.spring.runup.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.runup.user.vo.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SqlSession session;

	@Override
	public User getUser(User insertUser) {
		
		User user = session.selectOne("user.getUserByUserVo", insertUser);
		return user;
	}

}
