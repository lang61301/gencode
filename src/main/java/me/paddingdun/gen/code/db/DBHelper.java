/**
 * 
 */
package me.paddingdun.gen.code.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author paddingdun
 *
 * 2015年12月3日
 */
public class DBHelper {

	public static Connection getConnection()throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssh2?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull", "root", "root");
		return con;
	}
}
