/**
 * 
 */
package me.paddingdun.gen.code.data.project;

import java.io.Serializable;

/**
 * 实体信息;
 * @author paddingdun
 *
 * 2016年4月19日
 */
public class EntityInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 文件路径;
	 */
	private String path;
	
	/**
	 * 显示名称;
	 */
	private String name;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	
}
