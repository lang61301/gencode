/**
 * 
 */
package me.paddingdun.gen.code.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import me.paddingdun.gen.code.IConsant;
import me.paddingdun.gen.code.data.table.DBColumn;
import me.paddingdun.gen.code.data.table.IDBColumn;
import me.paddingdun.gen.code.data.table2.Entity;
import me.paddingdun.gen.code.data.table2.ListColumn;
import me.paddingdun.gen.code.data.table2.TableColumn;
import me.paddingdun.gen.code.data.tabletree.DBTable;
import me.paddingdun.gen.code.data.tabletree.IDBTable;
import me.paddingdun.gen.code.gui.model.EditViewModel;
import me.paddingdun.gen.code.util.BufferHelper;
import me.paddingdun.gen.code.util.ConfigHelper;
import me.paddingdun.gen.code.util.IOHelper;
import me.paddingdun.gen.code.util.ModelHelper;
import me.paddingdun.gen.code.util.TypesHelper;

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
	 * 表别名t1;
	 */
	public final static String TABLE_ALIAS_T1 = "t1";

	/**
	 * modify by 2016年4月8日
	 * 树节点数据由Table变更为IDBTable;
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
						
						IDBTable t = new DBTable();
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
	
	/**
	 * 根据数据库和表名称, 获取表字段列表;
	 * @param catalog
	 * @param tableName
	 * @return
	 */
	public static List<TableColumn>  tableColumn(String catalog, String tableName){
		List<TableColumn> result = new ArrayList<TableColumn>();
		Connection conn = null;
		ResultSet  rs1	= null;
		try{
			//缓存;
			String key = ConfigHelper.entityCfgName(catalog, tableName);
			Entity entityBuffer = BufferHelper.readEntity(key);
			
			conn = DBHelper.getConnection();
			DatabaseMetaData dmd =  conn.getMetaData();
			
			rs1 = dmd.getPrimaryKeys(catalog, null, tableName);
			Set<String> set_primary = new HashSet<String>(); 
			while(rs1.next()){
				set_primary.add(rs1.getString("COLUMN_NAME"));
			}
			rs1.close();
			
			rs1 = dmd.getColumns(catalog, null, tableName, null);
			while(rs1.next()){
				String name = rs1.getString("COLUMN_NAME");
				int type = rs1.getInt("DATA_TYPE");
				String common = rs1.getString("REMARKS");
				String is_autoincrement = rs1.getString("IS_AUTOINCREMENT");
				String is_nullable = rs1.getString("IS_NULLABLE");
				Integer column_size = rs1.getInt("COLUMN_SIZE");
				
				IDBColumn dbc = new DBColumn();
				dbc.setColumnName(name);
				dbc.setType(type);
				dbc.setColumnCommon(common);
				dbc.setTableName(tableName);
				
				if(set_primary.contains(name))
					dbc.setPrimary(true);
				
				if("YES".equals(is_autoincrement))
					dbc.setAutoIncrement(true);
				
				if("NO".equals(is_nullable)){
					dbc.setNullable(false);
				}
				
				if(column_size != null){
					dbc.setColumnSize(column_size);
				}
				
				/**
				 * add by 2016年4月11日
				 * 将dbColumn添加入缓存, 关联查询sql时使用;
				 */
				BufferHelper.writeDBColumn(tableName, name, dbc);
				
				TableColumn tc = new TableColumn(dbc);
				
				//设置字段在新增和编辑时的填值方式json;
				tc.setEditValueGenWayJson(ModelHelper.defaultEditValueGenWayJson(dbc));
				
				//如果判断字段为timestamp类型, 自动将editRenderShow = false
				if(TypesHelper.isTimestampType(type)){
					tc.setEditRenderShow(false);		
				}
				
				if(tc.isPrimary()){
					tc.setEditRenderShow(false);
				}
				
				//设置验证json字符串;
//				tc.setEditValidateJson(ModelHelper.defaultEditValidateJson(dbc));
				
				//设置校验easyui validate 字符串;
				tc.setEditValidateEasyuiString(ModelHelper.defaultEditEasyuiValidateString(dbc));
				
				//缓存更新;
				boolean hasBuffer = false;
				if(entityBuffer != null){
					List<TableColumn> list_tc = entityBuffer.getTableColumns();
					for (TableColumn tmp_tc : list_tc) {
						if(tc.equals(tmp_tc)){
							hasBuffer = true;
							result.add(tmp_tc);
							break;
						}
					}
				}
				
				if(!hasBuffer)
					result.add(tc);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			IOHelper.close(rs1);
			IOHelper.close(conn);
		}
		return result;
	}
	
	public static List<ListColumn>  listColumn(EditViewModel model){
		List<ListColumn> result = new ArrayList<ListColumn>();
		
		//缓存;
		String key = ConfigHelper.entityCfgName(model.getDbTable().getCat(), model.getDbTable().getTableName());
		Entity entityBuffer = BufferHelper.readEntity(key);
		
		for (IDBColumn dbColumn : model.getQuerySqlDBColumnList()) {
			ListColumn lc = new ListColumn(dbColumn);
			
			if(lc.isPrimary()){
			}else{
				lc.setQueryColumnJson(ModelHelper.defaultQueryColumnJson(dbColumn));
			}
			
			boolean cache = false;
			if(entityBuffer != null){
				List<ListColumn> tmp_list_lc = entityBuffer.getListColumns();
				if(tmp_list_lc != null
						&& !tmp_list_lc.isEmpty()){
					for (ListColumn tmp_lc : tmp_list_lc) {
						if(tmp_lc.equals(lc)){
							result.add(tmp_lc);
							cache = true;
							break;
						}
					}
				}
			}
			if(!cache)
				result.add(lc);
		}
		return result;
	}
	
	public static Vector<Vector<Object>>  transform1(List<TableColumn> list){
		Vector<Vector<Object>> result = new Vector<Vector<Object>>();
		for (TableColumn r : list) {
			String name = r.getColumnName();
//			int type = r.getType();
			String common = r.getColumnCommon();
			Vector<Object> el = new Vector<Object>();
//			el.add(Boolean.FALSE);
			el.add(Boolean.valueOf(r.isPrimary()));
			el.add(Boolean.valueOf(r.isAutoIncrement()));
			el.add(name);
			el.add(r.getColumnAlias());
			if(null == r.getSeq()){
				if(r.isPrimary())
					el.add(IConsant.DEF_MIN_SEQ);
				else
					el.add(IConsant.DEF_MAX_SEQ);
			}else{
				el.add(r.getSeq());
			}
//			el.add(r.getOrder());
			el.add(common);
			result.add(el);
		}
		return result;
	}
	
	/**
	 * add by 2016年4月11日
	 * 新增数据表查询语句返回;
	 * @param dbTable
	 * @return
	 */
	public static String tableName2QuerySql(DBTable dbTable, String tableAlias){
		String result = null;
		Connection conn = null;
		ResultSet  rs	= null;
		try{
			conn = DBHelper.getConnection();
			String catalog = dbTable.getCat();
			String tableName = dbTable.getTableName();
			DatabaseMetaData dmd =  conn.getMetaData();
			rs = dmd.getColumns(catalog, null, tableName, null);
			
			StringBuilder sb = new StringBuilder("select ");
			int cnt = 0;
			while(rs.next()){
				String columnName = rs.getString("COLUMN_NAME");
				if(cnt > 0){
					sb.append(", ");
				}
				sb.append(tableAlias + "." + columnName + " as " + columnName);
				cnt++;
			}
			sb.append(" from " + tableName + " " + tableAlias);
			sb.append("\r\n");
			result = sb.toString();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			IOHelper.close(rs);
			IOHelper.close(conn);
		}
		return result;
	}
	
	public static String tableName2DeleteSql(DBTable dbTable){
		String result = null;
		String tableName = dbTable.getTableName();
		StringBuilder sb = new StringBuilder("delete from " + tableName + " {$pk}");
		result = sb.toString();
		return result;
	}
	
	/**
	 * 根据catlog和sql获取sql;
	 * @param catlog
	 * @param sql
	 * @return
	 */
	public static List<IDBColumn> parseQuerySql(String catlog, String sql){
		List<IDBColumn> result = new ArrayList<IDBColumn>();
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBHelper.getConnection();
			conn.setCatalog(catlog);
			ps = conn.prepareStatement(sql);
			ResultSetMetaData rsmd = ps.getMetaData();
			int count = rsmd.getColumnCount();
			for (int i = 1; i <= count; i++) {
				int type = rsmd.getColumnType(i);
				String columnName = rsmd.getColumnName(i);
				String columnAliasName = rsmd.getColumnLabel(i);
				String tableName = rsmd.getTableName(i);
//				String _catlog = rsmd.getCatalogName(i);
				int size = rsmd.getColumnDisplaySize(i);
				
				IDBColumn dbColumn = BufferHelper.readDBColumn(tableName, columnName);
				if(dbColumn == null){
					dbColumn = new DBColumn();
//					dbColumn.setAutoIncrement(autoIncrement);
//					dbColumn.setColumnCommon(columnCommon);
//					dbColumn.setColumnName(columnName);
//					dbColumn.setNullable(nullable);
//					dbColumn.setPrimary(primary);
//					dbColumn.setTableAlias(tableAlias);
					dbColumn.setTableName(tableName);
					dbColumn.setType(type);
					dbColumn.setColumnSize(size);
					dbColumn.setColumnAlias(columnAliasName);
				}
				result.add(dbColumn);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			IOHelper.close(ps);
			IOHelper.close(conn);
		}
		return result;
	}
}
