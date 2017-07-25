/**
 * 
 */
package me.paddingdun.gen.code.util;

/**
 * 文件名称生成工具;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
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
	 * 实体文件基类;
	 * @param entityName
	 * @return
	 */
	public static String javaBaseEntityFileName(String entityName){
		return "Base" + entityName + ".java";
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
	 * sqlmap base xml 文件名称;
	 * @param entityName
	 * @return
	 */
	public static String sqlMapBaseXmlFileName(String entityName){
		return entityName + "_base_sql.xml";
	}
	
	/**
	 * java dao interface filename;
	 * @param entityName
	 * @return
	 */
	public static String sqlMapIDaoJavaFileName(String entityName){
		return sqlMapIDaoJavaClassName(entityName) + ".java";
	}
	
	public static String sqlMapBaseDaoJavaFileName(String entityName){
		return sqlMapBaseDaoJavaClassName(entityName) + ".java";
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
	 * java base dao interface class name;
	 * @param entityName
	 * @return
	 */
	public static String sqlMapBaseDaoJavaClassName(String entityName){
		return "Base" + entityName + "Dao";
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
	
	public static String sqlMapBaseServiceJavaFileName(String entityName){
		return sqlMapBaseServiceJavaClassName(entityName) + ".java";
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
	 * java base service interface class name;
	 * @param entityName
	 * @return
	 */
	public static String sqlMapBaseServiceJavaClassName(String entityName){
		return "Base" + entityName + "Service";
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
	 * java base service impl filename;
	 * @param entityName
	 * @return
	 */
	public static String sqlMapBaseServiceImplJavaFileName(String entityName){
		return "Base" + sqlMapServiceImplJavaClassName(entityName) + ".java";
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
	 * java base service impl class name;
	 * @param entityName
	 * @return
	 */
	public static String sqlMapBaseServiceImplJavaClassName(String entityName){
		return "Base" + entityName + "ServiceImpl";
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
	
	/**
	 * jsp page file name;
	 * @param entityName
	 * @return
	 */
	public static String bootstrapDataTableJspFileName(String entityName){
		return entityName + ".jsp";
	}
	
	/**
	 * add by 2017-07-21
	 * easyui list jsp page file name;
	 * @param entityName
	 * @return
	 */
	public static String easyuiListJspFileName(String entityName){
		return easyuiListFN(entityName) + ".jsp";
	}
	
	public static String easyuiListFN(String entityName){
		return entityName + "List";
	}
	
	/**
	 * add by 2017-07-21
	 * easyui edit jsp page file name;
	 * @param entityName
	 * @return
	 */
	public static String easyuiEditJspFileName(String entityName){
		return entityName + ".jsp";
	}
	
	/**
	 * the user config file name;
	 * @param name
	 * @return
	 */
	public static String configXmlFileName(String name){
		return name + ".xml";
	}
}
