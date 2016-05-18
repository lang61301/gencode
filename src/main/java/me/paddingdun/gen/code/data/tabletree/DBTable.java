/**
 * 
 */
package me.paddingdun.gen.code.data.tabletree;

/**
 * 数据库表描述实体;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public class DBTable implements IDBTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 数据库名称;
	 */
	private String cat;
	
	/**
	 * 数据库表名;
	 */
	private String tableName;
	
	/**
	 * 表类型: "TABLE"或者"VIEW";
	 */
	private String tableType;
	
	/**
	 * 表注释;
	 */
	private String tableCommon;
	
	@Override
	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	@Override
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public String getTableType() {
		return tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	@Override
	public String getTableCommon() {
		return tableCommon;
	}

	public void setTableCommon(String tableCommon) {
		this.tableCommon = tableCommon;
	}

	@Override
	public String toString() {
		return tableName;
	}
}
