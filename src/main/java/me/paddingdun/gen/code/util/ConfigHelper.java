/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.io.File;
import java.io.StringWriter;
import java.text.MessageFormat;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import me.paddingdun.gen.code.IConsant;
import me.paddingdun.gen.code.annotation.Value1;
import me.paddingdun.gen.code.data.table2.Entity;
import me.paddingdun.gen.code.db.DBType;
import me.paddingdun.gen.code.user.TableConfig;

/**
 * 用户自定义配置文件保存;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
@Component
@Lazy(false)
public class ConfigHelper {
	
	private static ConfigHelper helper = null;
	
	@PostConstruct
	public void init(){
		helper = this;
	}
	
	@Value1(def="mysql")
	private String database;
	
	/**
	 * 返回数据库类型;
	 * @return
	 */
	public static DBType database(){
		return DBType.parse(helper.getDatabase());
	}
	

	/**
	 * 表格配置文件名称;
	 * @param cataName
	 * @param tableName
	 * @return
	 */
	public static String entityCfgName(String cataName, String tableName){
		return MessageFormat.format("{0}_{1}", cataName, tableName);
	}
	
	public static String cfgDir(){
		return "project/pms";
	}
	
	/**
	 * 持久化模板参数;
	 * ibatis/2.0
	 * mybatis/3.0
	 * @return
	 */
	public static String persistentVMDir(){
		return IConsant.MYBATIS_VM;
	}
	
	public static void genConfigXmlFile(Entity entity){
		String charset = "utf-8";
		Gson gson = GsonHelper.create();
		try {
			String name = entityCfgName(entity.getCat(), entity.getTableName());
			System.out.println(gson.toJson(entity));
			byte[] gzip = GZipHelper.gzip(gson.toJson(entity), charset);
			
			
			TableConfig tc = new TableConfig();
			tc.setId(name);
			tc.setText(gzip);
			
			String content = convertToXml(tc, charset);
			
			FileHelper.genConfigXmlFile(DirectoryHelper.getUserDir(), cfgDir(), name, content);
			
			//更新缓存;
			BufferHelper.writeTable(name, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Entity readConfigXmlFile(File xml){
		Entity result = null;
		String charset = "utf-8";
		Gson gson = GsonHelper.create();
		try {
			TableConfig tc = convertToObject(TableConfig.class, xml);
			
			String str = GZipHelper.ungzip(tc.getText(), charset);
			result = gson.fromJson(str, new TypeToken<Entity>(){}.getType());
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
	
	@SuppressWarnings("unchecked")
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

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}
}
