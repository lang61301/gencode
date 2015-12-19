/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author paddingdun
 *
 * 2015年12月8日
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
		map_types.put(java.sql.Types.FLOAT, "java.lang.Float");
		map_types.put(java.sql.Types.REAL, "boolean");
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
	
	public static boolean isBooleanType(int type){
		if(type == java.sql.Types.REAL
				|| type== java.sql.Types.BOOLEAN)
			return true;
		else
			return false;
	}

}
