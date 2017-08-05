/**
 * 
 */
package me.paddingdun.gen.code.db;

/**
 * @author paddingdun
 *
 * Aug 5, 2017
 * @since 1.0
 * @version 1.0
 */
public enum DBType {

	mysql,
	sqlserver,
	postgres,
	db2,
	sybase,
	oracle;
	
	public static DBType parse(String name){
		for(DBType type : DBType.values()){
			if(type.name().equalsIgnoreCase(name)){
				return type;
			}
		}
		throw new RuntimeException("[" + name + "]invalid database type!");
	}
}
