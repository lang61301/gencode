/**
 * 
 */
package me.paddingdun.gen.code.data.table;



import me.paddingdun.gen.code.data.jsp.RenderWayType;
import me.paddingdun.gen.code.data.option.ModelValue;
import me.paddingdun.gen.code.data.option.ModelValueCategory;
import me.paddingdun.gen.code.util.EditValueGenWayHelper;

/**
 * @author paddingdun
 *
 * 2015年12月3日
 */
public class TableColumn extends DBColumn{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ModelValue(category=ModelValueCategory.Column, valueGetFuncName="getColumnAlias")
	private String columnAlias;
	
	/**
	 * 用来实现查询参数的json字符串, 关联对象QueryColumn
	 * 由于没有进一步ui操作设计, 因此直接用json字符串表示多个字段;
	 */
	private String queryColumnJson;
	
	/**
	 * 新增和编辑时,该字段值的生成方式;
	 */
	private String editValueGenWayJson;
	
	/**
	 * add by 2016年3月17日
	 * 新增和编辑时, 验证规则json;
	 * jquery.bootstrap.validate
	 */
	private String editValidateJson;
	
	
	/**
	 * @param columnName
	 * @param type
	 * @param columnCommon
	 */
	public TableColumn(String columnName, int type, String columnCommon) {
		super(columnName, type, columnCommon);
	}
	
	public TableColumn(DBColumn dbColumn){
		this(dbColumn.getColumnName(), dbColumn.getType(), dbColumn.getColumnCommon());
		this.setAutoIncrement(dbColumn.isAutoIncrement());
		this.setPrimary(dbColumn.isPrimary());
	}
	
	private String javaType;
	private String propertyName;
	private String getMethod;
	private String setMethod;


	public String getJavaType() {
		return javaType;
	}
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getGetMethod() {
		return getMethod;
	}
	public void setGetMethod(String getMethod) {
		this.getMethod = getMethod;
	}
	public String getSetMethod() {
		return setMethod;
	}
	public void setSetMethod(String setMethod) {
		this.setMethod = setMethod;
	}
	
	public String getColumnAlias() {
		if(columnAlias == null)
			columnAlias = this.getColumnName();
		return columnAlias;
	}
	public void setColumnAlias(String columnAlias) {
		this.columnAlias = columnAlias;
	}



	private boolean gson = true;


	public boolean isGson() {
		return gson;
	}
	public void setGson(boolean gson) {
		this.gson = gson;
	}
	
	
	/***jsp使用********************************************************************************/
	/**
	 * 是否显示;
	 */
	private boolean queryRenderShow = false;
	/**
	 * 是否显示;
	 */
	private boolean listRenderShow = true;
	/**
	 * 是否显示;
	 */
	private boolean editRenderShow = true;
	
	/**
	 * 用来定义查询显示方式;
	 */
	private int queryRenderWay = RenderWayType.query_default.getType();
	/**
	 * 用来定义列表显示方式;
	 */
	private int listRenderWay  = RenderWayType.list_default.getType();
	/**
	 * 用来定义编辑列显示方式;
	 */
	private int editRenderWay  = RenderWayType.edit_default.getType();
	
	/**
	 * 列标题;
	 */
	private String columnTitle;
	
	public boolean isQueryRenderShow() {
		return queryRenderShow;
	}
	public void setQueryRenderShow(boolean queryRenderShow) {
		this.queryRenderShow = queryRenderShow;
	}
	public boolean isListRenderShow() {
		return listRenderShow;
	}
	public void setListRenderShow(boolean listRenderShow) {
		this.listRenderShow = listRenderShow;
	}
	public boolean isEditRenderShow() {
		return editRenderShow;
	}
	public void setEditRenderShow(boolean editRenderShow) {
		this.editRenderShow = editRenderShow;
	}
	public int getQueryRenderWay() {
		return queryRenderWay;
	}
	public void setQueryRenderWay(int queryRenderWay) {
		this.queryRenderWay = queryRenderWay;
	}
	public int getListRenderWay() {
		return listRenderWay;
	}
	public void setListRenderWay(int listRenderWay) {
		this.listRenderWay = listRenderWay;
	}
	public int getEditRenderWay() {
		return editRenderWay;
	}
	public void setEditRenderWay(int editRenderWay) {
		this.editRenderWay = editRenderWay;
	}
	public String getColumnTitle() {
		if(columnTitle == null){
			columnTitle = this.getColumnCommon();
		}
		return columnTitle;
	}
	public void setColumnTitle(String columnTitle) {
		this.columnTitle = columnTitle;
	}
	
	public String getQueryColumnJson() {
		return queryColumnJson;
	}
	public void setQueryColumnJson(String queryColumnJson) {
		this.queryColumnJson = queryColumnJson;
	}
	
	public String getEditValueGenWayJson() {
		return editValueGenWayJson;
	}
	public void setEditValueGenWayJson(String editValueGenWayJson) {
		this.editValueGenWayJson = editValueGenWayJson;
	}
	
	/**
	 * 判断该字段是否可以存在updatesql中的set语句中;
	 * @return
	 */
	public boolean isNotInSetUpdateSql(){
		return EditValueGenWayHelper.isNotInSetUpdateSql(this);
	}
	
	
	public String getEditValidateJson() {
		return editValidateJson;
	}

	public void setEditValidateJson(String editValidateJson) {
		this.editValidateJson = editValidateJson;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableColumn other = (TableColumn) obj;
		if (this.getColumnName() == null) {
			if (other.getColumnName() != null)
				return false;
		} else if (!this.getColumnName().equals(other.getColumnName()))
			return false;
		return true;
	}
}
