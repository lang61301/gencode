/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author paddingdun
 *
 * 2015年12月3日
 */
public class IOHelper {
	
	public static void close(InputStream in){
		if(in != null){
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				in = null;
			}
		}
	}
	
	public static void close(OutputStream out){
		if(out != null){
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				out = null;
			}
		}
	}
	
	public static void close(Reader reader){
		if(reader != null){
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				reader = null;
			}
		}
	}
	
	public static void close(Writer writer){
		if(writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					writer = null;
				}
		}
	}

	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn = null;
			}
		}
	}
	
	public static void close(Statement statement){
		if(statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				statement = null;
			}
		}
	}
	
	public static void close(ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs = null;
			}
		}
	}
}
