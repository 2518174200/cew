package commons;
/**
 * ���ִ�ж���Ĺ�����
 * @author lindy
 * @����ʱ�� 2020��3��31������4:34:50
 */

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	private static SqlSessionFactory fac;
	static {
		InputStream is;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
			fac = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// ����һ�����SqlSession����ķ���
	public static SqlSession createSqlSession() {
		return fac.openSession(false);
	}
	
	// ����һ���ر�SqlSession����ķ���
	public static void close(SqlSession sqlSession) {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
}
