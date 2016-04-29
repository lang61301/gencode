/**
 * 
 */
package me.paddingdun.gen.code.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import me.paddingdun.gen.code.data.tabletree.DBTable;
import me.paddingdun.gen.code.util.IOHelper;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 2.0
 * @version 2.0
 */
public class TableHelper2 {

	/**
	 * modify by 2016年4月8日
	 * 树节点数据由Table变更为DBTable;
	 * @return
	 */
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
						String remark = rs2.getString("REMARKS");
						
						DefaultMutableTreeNode node_table  = new DefaultMutableTreeNode();
						
						DBTable t = new DBTable();
						t.setCat(cat);
						t.setTableName(name);
						t.setTableType(type);
						t.setTableCommon(remark);
						node_table.setUserObject(t);
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
}
