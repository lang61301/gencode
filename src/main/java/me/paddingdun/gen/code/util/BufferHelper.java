/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import me.paddingdun.gen.code.data.table.DBColumn;
import me.paddingdun.gen.code.data.tabletree.Table;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public class BufferHelper {

	/**
	 * table缓存配置;
	 */
	public static Map<String, Table> BUFFER_CFG_TABLE = new HashMap<String, Table>();
	
	/**
	 * 曾经点击生成过的dbcolumn的缓存;
	 */
	public static Map<String, DBColumn> BUFFER_DBCOLUMN = new HashMap<String, DBColumn>();
	
	
	public static void writeTable(String key, Table table){
		BUFFER_CFG_TABLE.put(key, table);
	}
	
	public static Table readTable(String key){
		return BUFFER_CFG_TABLE.get(key);
	}
	
	private static String dbColumnKey(String tableName, String columnName){
		return tableName + "." + columnName;
	}
	
	public static void writeDBColumn(String tableName, String columnName, DBColumn dbColumn){
		BUFFER_DBCOLUMN.put(dbColumnKey(tableName, columnName), dbColumn);
	}
	
	public static DBColumn readDBColumn(String tableName, String columnName){
		return BUFFER_DBCOLUMN.get(dbColumnKey(tableName, columnName));
	}
	
	
	/**
	 * 读取table内存;
	 * @param baseDir
	 * @param categoryDir
	 */
	public static void readConfigXmlBuffer(String baseDir, String categoryDir){
		try {
			File dir = null;
			if(StringUtils.isNotBlank(categoryDir)){
				dir = new File(baseDir, categoryDir);
			}else{
				dir = new File(baseDir);
			}
			if(!dir.exists())
				dir.mkdirs();
			
			File[] xmls = dir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith(".xml");
				}
			});
			
			if(xmls != null)
				for (File xml : xmls) {
					Table tmp = ConfigHelper.readConfigXmlFile(xml);
					if(tmp != null){
						String name = FilenameUtils.getBaseName(xml.getName());
						
						writeTable(name, tmp);
					}
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
