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

import me.paddingdun.gen.code.data.tabletree.Table;

/**
 * @author paddingdun
 *
 * 2016年2月15日
 */
public class BufferHelper {

	public static Map<String, Table> BUFFER_CFG_TABLE = new HashMap<String, Table>();
	
	
	public static void writeTable(String key, Table table){
		BUFFER_CFG_TABLE.put(key, table);
	}
	
	public static Table readTable(String key){
		return BUFFER_CFG_TABLE.get(key);
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
