/**
 * 
 */
package me.paddingdun.gen.code.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author paddingdun
 *
 * 2016年2月3日
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement  
@XmlType
public class UserConfig {

	@XmlElement
	private TableConfig tableConfig;

	public TableConfig getTableConfig() {
		return tableConfig;
	}

	public void setTableConfig(TableConfig tableConfig) {
		this.tableConfig = tableConfig;
	}
}
