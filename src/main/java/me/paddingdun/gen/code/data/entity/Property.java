/**
 * 
 */
package me.paddingdun.gen.code.data.entity;

import java.io.Serializable;

import me.paddingdun.gen.code.util.TypesHelper;

/**
 * @author paddingdun
 *
 * 2015年12月8日
 */
public class Property implements Serializable {

	private String columnName;
	private int type;
	
	
	@Override
	public String toString() {
		String s = TypesHelper.map_types.get(type);
		
		return null;
	}
}
