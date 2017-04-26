/**
 * 
 */
package me.paddingdun.gen.code;

import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.pagination.LimitHandler;
import org.hibernate.engine.spi.RowSelection;

/**
 * 使用hibernate为sql添加分页;
 * 
 * 2017-04-19
 * 备注:由于sqlserver2000没有特别标准的分页实现, 因此hibernate采取的是内存分页;
 * 
 * @author paddingdun
 *
 * Apr 18, 2017
 * @since 1.0
 * @version 1.0
 */
public class HibernatePaginTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String sql = " select  * from a ";
		// TODO Auto-generated method stub
//		Configuration cfg = new Configuration().setProperty("hibernate.dialect","org.hibernate.dialect.MySQLInnoDBDialect");
//		Configuration cfg = new Configuration().setProperty("hibernate.dialect","org.hibernate.dialect.SQLServerDialect");
//		Configuration cfg = new Configuration().setProperty("hibernate.dialect","org.hibernate.dialect.OracleDialect");
//		Configuration cfg = new Configuration().setProperty("hibernate.dialect","org.hibernate.dialect.SQLServer2005Dialect");
//		Configuration cfg = new Configuration().setProperty("hibernate.dialect","org.hibernate.dialect.OracleDialect");
//		Configuration cfg = new Configuration().setProperty("hibernate.dialect","org.hibernate.dialect.OracleDialect");
		RowSelection rs = new RowSelection();
		rs.setFirstRow(10);
		rs.setMaxRows(10);
		Properties props = new Properties();
		props.setProperty(Environment.DIALECT, "org.hibernate.dialect.OracleDialect");
		Dialect dia = org.hibernate.dialect.SQLServer2012Dialect.getDialect(props);
		
		LimitHandler lh = org.hibernate.dialect.SQLServer2012Dialect.getDialect(props).buildLimitHandler(sql, rs);
		String newSql = lh.getProcessedSql();
		System.out.println(newSql);
//		 ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build(); 
//	        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
//	        Session s = sessionFactory.openSession();
//	        SQLQuery query =  s.createSQLQuery("select * from a");
//	        query.setFirstResult(50);
//	        query.setMaxResults(10);
//	        query.list();
//	        s.close();
//		cfg.buildSessionFactory(null);
	}

}
