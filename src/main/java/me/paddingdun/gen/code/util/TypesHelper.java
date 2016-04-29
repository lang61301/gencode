/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public class TypesHelper {
	/**
	 * 类型转换;
	 */
	final public static Map<Integer, String> map_types = new HashMap<Integer, String>(); 
	static{
		map_types.put(java.sql.Types.TINYINT, "java.lang.Integer");
		map_types.put(java.sql.Types.SMALLINT, "java.lang.Integer");
		map_types.put(java.sql.Types.INTEGER, "java.lang.Integer");
		map_types.put(java.sql.Types.BIGINT, "java.lang.Long");
		map_types.put(java.sql.Types.FLOAT, "java.lang.Double");
		map_types.put(java.sql.Types.REAL, "java.lang.Float");
		map_types.put(java.sql.Types.DOUBLE, "java.lang.Double");
		map_types.put(java.sql.Types.NUMERIC, "java.math.BigDecimal");
		map_types.put(java.sql.Types.DECIMAL, "java.math.BigDecimal");
		map_types.put(java.sql.Types.CHAR, "java.lang.Character");
		map_types.put(java.sql.Types.VARCHAR, "java.lang.String");
		map_types.put(java.sql.Types.LONGVARCHAR, "java.lang.String");
		map_types.put(java.sql.Types.DATE, "java.sql.Date");
		map_types.put(java.sql.Types.TIME, "java.sql.Timestamp");
		map_types.put(java.sql.Types.TIMESTAMP, "java.sql.Timestamp");
		map_types.put(java.sql.Types.BOOLEAN, "java.lang.Boolean");
		map_types.put(java.sql.Types.ROWID, "java.lang.String");
		map_types.put(java.sql.Types.NCHAR, "java.lang.String");
		map_types.put(java.sql.Types.NVARCHAR, "java.lang.String");
		map_types.put(java.sql.Types.LONGNVARCHAR, "java.lang.String");
	}
	
	public static Object convertBasic(Class<?> clazz, String obj){
		if(obj == null)return null;
		
		if(clazz == int.class){
			return new BigDecimal(obj).intValue();
		}else if(clazz == long.class){
			return new BigDecimal(obj).longValue();
		}else if(clazz == float.class){
			return new BigDecimal(obj).floatValue();
		}else if(clazz == double.class){
			return new BigDecimal(obj).doubleValue();
		}else if(clazz == char.class){
			return Character.valueOf(obj.charAt(0)).charValue();
		}else if(clazz == byte.class){
			
		}else if(clazz == short.class){
			return new BigDecimal(obj).shortValue();
		}else if(clazz == boolean.class){
			return Boolean.valueOf(obj).booleanValue();
		}else if(clazz == java.lang.Short.class){
			return new BigDecimal(obj).shortValue();
		}else if(clazz == java.lang.Integer.class){
			return new BigDecimal(obj).intValue();
		}else if(clazz == java.lang.Long.class){
			return new BigDecimal(obj).longValue();
		}else if(clazz == java.lang.Float.class){
			return new BigDecimal(obj).floatValue();
		}else if(clazz == java.lang.Double.class){
			return new BigDecimal(obj).doubleValue();
		}else if(clazz == java.lang.Byte.class){
			
		}else if(clazz == java.lang.Boolean.class){
			return Boolean.valueOf(obj);
		}else if(clazz == java.lang.Character.class){
			return Character.valueOf(obj.charAt(0));
		}else if(clazz == java.lang.String.class){
			return obj;
		}
		return obj;
	}
	
	public static boolean isTimestampType(int type){
		if(type== java.sql.Types.TIMESTAMP
				|| type == java.sql.Types.TIME)
			return true;
		else
			return false;
	}
	
	public static boolean isDateType(int type){
		if(type== java.sql.Types.DATE)
			return true;
		else
			return false;
	}
	
	public static boolean isBooleanType(int type){
		if(type== java.sql.Types.BOOLEAN)
			return true;
		else
			return false;
	}
	
	public static boolean isBooleanType(String javaType){
		if(Boolean.class.getName().equals(javaType)
				||boolean.class.getName().equals(javaType))
			return true;
		else
			return false;
	}
	
	public static boolean isStringType(String javaType){
		if(String.class.getName().equals(javaType))
			return true;
		else
			return false;
	}
	
	public static boolean isIntegerType(String javaType){
		if(Integer.class.getName().equals(javaType)
				|| Long.class.getName().equals(javaType))
			return true;
		else
			return false;
	}

}
