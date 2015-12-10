/**
 * 
 */
package me.paddingdun.gen.code.db;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author paddingdun
 *
 * 2015年12月3日
 */
@Component
@Lazy(false)
public class DBHelper {
	
	private static DBHelper helper;
	
	@PostConstruct
	public void init(){
		helper = this;
	}
	
	@Resource(name="dataSource")
	private DataSource ds;

	public static Connection getConnection()throws Exception{
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssh2?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull", "root", "root");
		return helper.ds.getConnection();
	}
}
