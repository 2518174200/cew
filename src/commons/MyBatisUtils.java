package commons;
/**
 * 获得执行对象的工具类
 * @author lindy
 * @创建时间 2020年3月31日下午4:34:50
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
	
	// 创建一个获得SqlSession对象的方法
	public static SqlSession createSqlSession() {
		return fac.openSession(false);
	}
	
	// 创建一个关闭SqlSession对象的方法
	public static void close(SqlSession sqlSession) {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
}
