/**
 * 
 */
package me.paddingdun.gen.code;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * @author paddingdun
 *
 * 2015年12月3日
 */
public class TestJGraphx {

	public static void main(String[] args)throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		ResultSet rs = null;
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssh2?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull", "root", "root");
		
		DatabaseMetaData dmd =  con.getMetaData();
		rs = dmd.getSchemas();
		while(rs.next()){
			System.out.println(rs.getString("TABLE_SCHEM"));
		}
		rs.close();
		System.out.println("---------------");
		rs = dmd.getCatalogs();
		while(rs.next()){
			System.out.println(rs.getString("TABLE_CAT"));
		}
		rs.close();
		System.out.println("---------------");
		rs = dmd.getTables("ssh2", null, null, null);
		while(rs.next()){
//			int  i = rs.getMetaData().getColumnCount();
//			for (int j = 0; j < i; j++) {
//				System.out.println(rs.getObject(j));
//			}
			System.out.println(rs.getString("TABLE_NAME"));
			System.out.println(rs.getString("TABLE_TYPE"));
		}
		rs.close();
		System.out.println("---------------");
		
		rs = dmd.getColumns("ssh2", null, "tb_user", null);
		while(rs.next()){
//			int  i = rs.getMetaData().getColumnCount();
//			for (int j = 0; j < i; j++) {
//				System.out.println(rs.getObject(j));
//			}
			System.out.println(rs.getString("COLUMN_NAME"));
			System.out.println(rs.getString("TYPE_NAME"));
		}
		rs.close();
		
		
		con.close();
	}
}
