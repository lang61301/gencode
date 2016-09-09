/**
 * 
 */
package me.paddingdun.gen.code.data.edit;

/**
 * @author paddingdun
 *
 * 2016年9月9日
 * @since 1.0
 * @version 1.0
 */
public class Datasource {

	/**
	 * 类型;
	 * local,ajax
	 */
	private String type = "local";
	
	/**
	 * 元素中的文本对应的key;
	 */
	private String textKey = "text";
	
	/**
	 * 元素中的值对应的key;
	 */
	private String valueKey = "value";
	
	/**
	 * 本地类型时,javascript变量名称;
	 */
	private String varName;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTextKey() {
		return textKey;
	}

	public void setTextKey(String textKey) {
		this.textKey = textKey;
	}

	public String getValueKey() {
		return valueKey;
	}

	public void setValueKey(String valueKey) {
		this.valueKey = valueKey;
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}
}
