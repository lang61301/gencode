/**
 * 
 */
package me.paddingdun.gen.code.data.tabletree;

/**
 * 包裹IDBTable类;
 * @author paddingdun
 *
 * 2016年5月13日
 * @since 2.0
 * @version 2.0
 */
public class WapperDBTable implements IDBTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IDBTable table;
	
	public WapperDBTable(IDBTable table){
		this.table = table;
	}

	public void setCat(String catalog) {
		table.setCat(catalog);
	}

	public String getCat() {
		return table.getCat();
	}

	public void setTableName(String tableName) {
		table.setTableName(tableName);
	}

	public String getTableName() {
		return table.getTableName();
	}

	public void setTableType(String tableType) {
		table.setTableType(tableType);
	}

	public String getTableType() {
		return table.getTableType();
	}

	public void setTableCommon(String common) {
		table.setTableCommon(common);
	}

	public String getTableCommon() {
		return table.getTableCommon();
	}
}
