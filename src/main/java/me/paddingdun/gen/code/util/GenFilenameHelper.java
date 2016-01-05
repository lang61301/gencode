/**
 * 
 */
package me.paddingdun.gen.code.util;

/**
 * 文件名称生成工具;
 * @author paddingdun
 *
 * 2015年12月29日
 */
public class GenFilenameHelper {

	/**
	 * 实体文件名称;
	 * @param entityName
	 * @return
	 */
	public static String javaEntityFileName(String entityName){
		return entityName + ".java";
	}
	
	/**
	 * sqlmap xml 文件名称;
	 * @param entityName
	 * @return
	 */
	public static String sqlMapXmlFileName(String entityName){
		return entityName + "_sql.xml";
	}
	
	/**
	 * java dao interface filename;
	 * @param entityName
	 * @return
	 */
	public static String sqlMapIDaoJavaFileName(String entityName){
		return sqlMapIDaoJavaClassName(entityName) + ".java";
	}
	
	/**
	 * java dao interface class name;
	 * @param entityName
	 * @return
	 */
	public static String sqlMapIDaoJavaClassName(String entityName){
		return "I" + entityName + "Dao";
	}
	
	/**
	 * java dao impl filename;
	 * @param entityName
	 * @return
	 */
	public static String sqlMapDaoImplJavaFileName(String entityName){
		return sqlMapDaoImplJavaClassName(entityName) + ".java";
	}
	
	/**
	 * java dao impl class name;
	 * @param entityName
	 * @return
	 */
	public static String sqlMapDaoImplJavaClassName(String entityName){
		return entityName + "DaoImpl";
	}
	
	/**
	 * java service interface filename;
	 * @param entityName
	 * @return
	 */
	public static String sqlMapIServiceJavaFileName(String entityName){
		return sqlMapIServiceJavaClassName(entityName) + ".java";
	}
	
	/**
	 * java service interface class name;
	 * @param entityName
	 * @return
	 */
	public static String sqlMapIServiceJavaClassName(String entityName){
		return "I" + entityName + "Service";
	}
	
	/**
	 * java service impl filename;
	 * @param entityName
	 * @return
	 */
	public static String sqlMapServiceImplJavaFileName(String entityName){
		return sqlMapServiceImplJavaClassName(entityName) + ".java";
	}
	
	/**
	 * java service impl class name;
	 * @param entityName
	 * @return
	 */
	public static String sqlMapServiceImplJavaClassName(String entityName){
		return entityName + "ServiceImpl";
	}
	
	/**
	 * java spring web controller class name;
	 * @param entityName
	 * @return
	 */
	public static String springWebActionJavaClassName(String entityName){
		return entityName + "Ctrl";
	}
	/**
	 * java spring web controller java class file name;
	 * @param entityName
	 * @return
	 */
	public static String springWebActionJavaFileName(String entityName){
		return springWebActionJavaClassName(entityName) + ".java";
	}
}
