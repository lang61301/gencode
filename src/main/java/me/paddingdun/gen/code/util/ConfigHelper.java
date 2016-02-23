/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.MessageFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FilenameUtils;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import me.paddingdun.gen.code.data.tabletree.Table;
import me.paddingdun.gen.code.user.TableConfig;

/**
 * @author paddingdun 用户自定义配置文件保存; 2016年2月3日
 */
public class ConfigHelper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	/**
	 * 表格配置文件名称;
	 * @param catName
	 * @param tableName
	 * @return
	 */
	public static String tableCfgName(String catName, String tableName){
		return MessageFormat.format("{0}_{1}", catName, tableName);
	}
	
	public static void genConfigXmlFile(Table table){
		String charset = "utf-8";
		Gson gson = GsonHelper.create();
		try {
			String name = tableCfgName(table.getCat(), table.getTableName());
			byte[] gzip = GZipHelper.gzip(gson.toJson(table), charset);
			
			
			TableConfig tc = new TableConfig();
			tc.setId(name);
			tc.setText(gzip);
			
			String content = convertToXml(tc, charset);
			
			FileHelper.genConfigXmlFile(DirectoryHelper.getUserDir(), "table", name, content);
			
			//更新缓存;
			BufferHelper.writeTable(name, table);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Table readConfigXmlFile(File xml){
		Table result = null;
		String charset = "utf-8";
		Gson gson = GsonHelper.create();
		try {
			TableConfig tc = convertToObject(TableConfig.class, xml);
			
			String str = GZipHelper.ungzip(tc.getText(), charset);
			
			result = gson.fromJson(str, new TypeToken<Table>(){}.getType());
		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		}
		return result;
	}

	public static String convertToJson(Object obj, String encoding) {
		String result = null;
		Gson gson = GsonHelper.create();
		result = gson.toJson(obj);
		return result;
	}

	public static String convertToXml(Object obj, String encoding) {
		String result = null;
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

			StringWriter writer = new StringWriter();
			marshaller.marshal(obj, writer);
			result = writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public static <T> T convertToObject(Class<T> clazz, File xml) {
		T result = null;
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			result = (T) unmarshaller.unmarshal(xml);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
