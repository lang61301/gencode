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
	public static String javaEntityFile(String entityName){
		return entityName + ".java";
	}
	
	/**
	 * sqlmap xml 文件名称;
	 * @param entityName
	 * @return
	 */
	public static String sqlMapXmlFile(String entityName){
		return entityName + "_sql.xml";
	}
	
	/**
	 * java dao interface filename;
	 * @param entityName
	 * @return
	 */
	public static String sqlMapIDaoJavaFile(String entityName){
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
	public static String sqlMapDaoImplJavaFile(String entityName){
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
	public static String sqlMapIServiceJavaFile(String entityName){
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
	public static String sqlMapServiceImplJavaFile(String entityName){
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
}
