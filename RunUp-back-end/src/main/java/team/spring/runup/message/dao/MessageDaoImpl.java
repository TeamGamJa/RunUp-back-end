package team.spring.runup.message.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.runup.message.vo.Message;

@Repository
public class MessageDaoImpl implements MessageDao {
	
	@Autowired
	private SqlSession session;

	public int create(Message message) throws Exception {
		return session.insert("message.insert", message);
	}

}
