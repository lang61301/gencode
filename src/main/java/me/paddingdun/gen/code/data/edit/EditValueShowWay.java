/**
 * 
 */
package me.paddingdun.gen.code.data.edit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import me.paddingdun.gen.code.data.jsp.RenderWayType;

/**
 * 显示方式;
 * @author paddingdun
 *
 * 2016年9月9日
 * @since 2.0
 * @version 2.0
 */
public class EditValueShowWay {

	/**
	 * 对应EditValueGenWay
	 */
	private String category;
	
	/**
	 * 
	 */
	private String html;
	
	/**
	 * 数据源;
	 */
	private Datasource dataSource;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public Datasource getDataSource() {
		return dataSource;
	}

	public void setDataSource(Datasource dataSource) {
		this.dataSource = dataSource;
	}
}
