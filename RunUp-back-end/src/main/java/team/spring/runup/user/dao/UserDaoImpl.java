package team.spring.runup.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.runup.running.vo.Running;
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

	@Override
	public User getUserById(String userId) {
		User user = session.selectOne("user.getUserByUserId", userId);
		return user;
	}
	
	@Override
	public String getUserUrlByUserNum(int userNum) {
		String result = session.selectOne("user.getUserUrlByUserNum", userNum);
		return result;
	}
	
	@Override
	public List<User> getUserByNickname(String userNickname) {
		List<User> user = session.selectList("user.getUserByNickname", userNickname);
		return user;
	}
	
	@Override
	public User getUserByNum(int userNum) {
		User user = session.selectOne("user.getUserByNum", userNum);
		return user;
	}
	
	@Override
	public int getPointByUserNickname(User user) {
		int result = session.selectOne("user.getPointByUserNickname",user);
		return result;
	}
	
	@Override
	public int registUser(User user) {
		int result = session.insert("user.registUser", user);
		return result;
	}

	@Override
	public int updateUser(User user) {
		int result = session.update("user.updateUser", user);
		return result;
	}
	
	@Override
	public int updateProfile(User user) {
		int result = session.update("user.updateProfile", user);
		return result;
	}
	
	@Override
	public int updateUserLuxColor(User user) {
		int result = session.update("user.updateUserLuxColor", user);
		return result;
	}
	
	@Override
	public int deleteUser(String userId) {
		int result = session.update("user.deleteUser", userId);
		return result;
	}

	@Override
	public String getUserByIdPhone(User insertUser) {
		String userId = session.selectOne("user.getUserByIdPhone", insertUser);
		return userId;
	}

	@Override
	public int changePw(User user) {
		int result = session.update("user.changePw", user);
		return result;
	}

	@Override
	public int checkUserNickName(String userNickname) {
		int result = session.selectOne("user.checkUserNicknameExist", userNickname);
		return result;
	}

	@Override
	public int updateUserCategory(User user) {
		int result = session.update("user.updateCategory", user);
		return result;
	}
	
	@Override
	public int updateFinishLearning(User user) {
		int result = session.update("user.updateFinishLearning",user);
		return result;
	}
	
	@Override
	public int updateFinishRunning(User user) {
		int result = session.update("user.updateFinishRunning",user);
		return result;
	}

	@Override
	public int checkUserById(String userId) {
		int result = session.selectOne("user.checkUserIdExist", userId);
		return result;
	}

}
