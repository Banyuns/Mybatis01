package cn.smbms.dao.user;

import java.io.IOException;
import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

public class UserTest {
	
	private Logger logger = Logger.getLogger(UserTest.class);
	
	@Test
	public void getCount(){
		String res = "mybatis-config.xml";
		int count = 0;
		SqlSession sqlsession = null;
		
		try {
			InputStream is =Resources.getResourceAsStream(res);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			sqlsession = factory.openSession();
			count = sqlsession.selectOne("cn.smbms.dao.user.UserMapper.count");
			System.out.println(count);
			logger.debug(count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlsession.close();
		}
		
		
		
	} 
}
