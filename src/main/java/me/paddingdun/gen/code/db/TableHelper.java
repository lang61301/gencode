/**
 * 
 */
package me.paddingdun.gen.code.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import me.paddingdun.gen.code.data.table.TableRecord;
import me.paddingdun.gen.code.data.tabletree.Table;
import me.paddingdun.gen.code.util.IOHelper;

/**
 * @author paddingdun
 *
 * 2015年12月3日
 */
public class TableHelper {

	public static TreeNode  TableTreeNode(){
		Connection conn = null;
		ResultSet  rs1	= null;
		ResultSet  rs2	= null;
		DefaultMutableTreeNode root  = new DefaultMutableTreeNode();
		try{
			conn = DBHelper.getConnection();
			DatabaseMetaData dmd =  conn.getMetaData();
			
			//获取数据库名称;
			rs1 = dmd.getCatalogs();
			while(rs1.next()){
				String dbName = rs1.getString("TABLE_CAT");
				DefaultMutableTreeNode node_db  = new DefaultMutableTreeNode();
				node_db.setUserObject(dbName);
				root.add(node_db);
				
				try{
					rs2 = dmd.getTables(dbName, null, null, new String[]{"TABLE", "VIEW"});
					while(rs2.next()){
						String cat  = rs2.getString("TABLE_CAT");
						String name = rs2.getString("TABLE_NAME");
						String type = rs2.getString("TABLE_TYPE");
						
						DefaultMutableTreeNode node_table  = new DefaultMutableTreeNode();
						node_table.setUserObject(new Table(cat, name, type));
						node_db.add(node_table);
					}
				}finally{
					IOHelper.close(rs2);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			IOHelper.close(rs1);
			IOHelper.close(conn);
		}
		return root;
	}
	
	public static Vector<Vector<Object>>  tableRecord(String catalog, String tableName){
		Vector<Vector<Object>> result = new Vector<Vector<Object>>();
		Connection conn = null;
		ResultSet  rs1	= null;
		try{
			conn = DBHelper.getConnection();
			DatabaseMetaData dmd =  conn.getMetaData();
			
			rs1 = dmd.getColumns(catalog, null, tableName, null);
			while(rs1.next()){
				String name = rs1.getString("COLUMN_NAME");
				int type = rs1.getInt("DATA_TYPE");
				String common = rs1.getString("REMARKS");
				Vector<Object> el = new Vector<Object>();
//				el.add(Boolean.FALSE);
				el.add(name);
				el.add(type);
				el.add(common);
				result.add(el);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			IOHelper.close(rs1);
			IOHelper.close(conn);
		}
		return result;
	}
}
