/**
 * 
 */
package me.paddingdun.gen.code.data.table2;

import me.paddingdun.gen.code.data.jsp.Render;
import me.paddingdun.gen.code.data.jsp.RenderWayType;
import me.paddingdun.gen.code.data.table.IDBColumn;
import me.paddingdun.gen.code.util.EditValueGenWayHelper;

/**
 * 表字段;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 2.0
 * @version 2.0
 */
public class TableColumn extends WapperDBColumn implements IEntityProperty, Comparable<TableColumn> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String javaType;		/** java fully qualified name **/
	private String propertyName;	/** property name **/
	private String getMethod;		/** get method name **/
	private String setMethod;		/** set method name **/
	private String propertyTitle;	/** property description **/

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

	public String getPropertyTitle() {
		return propertyTitle;
	}

	public void setPropertyTitle(String propertyTitle) {
		this.propertyTitle = propertyTitle;
	}
	
	
	/**
	 * @param dbColumn
	 */
	public TableColumn(IDBColumn dbColumn) {
		super(dbColumn);
	}

	/**
	 * 编辑中是否显示;
	 */
	private boolean editRenderShow = true;
	
	/**
	 * 编辑中显示方式;
	 * 用来定义编辑列显示方式;
	 */
	private int editRenderWay  = RenderWayType.edit_default.getType();
	
	/**
	 * 填值方式;
	 * 新增和编辑时,该字段值的生成方式;
	 */
	private String editValueGenWayJson;
	
	/**
	 * JS验证;
	 * 新增和编辑时, 验证规则json;
	 * jquery.bootstrap.validate
	 */
	private String editValidateJson;
	
	/**
	 * 判断该字段是否可以存在updatesql中的set语句中;
	 * @return
	 */
	public boolean isNotInSetUpdateSql(){
		return EditValueGenWayHelper.isNotInSetUpdateSql(editValueGenWayJson);
	}
	
	/**
	 * add by 2016年5月16日
	 * 新增/编辑列表排序,  按照从小到大的顺序排列;
	 */
	private Integer seq;
	
	/**
	 * 是否显示gson序列化名称;
	 */
	private boolean gson;
	
	/**
	 * 新增/编辑字段标题;
	 */
	private String columnTitle;
	
	/**
	 * add or edit;
	 */
	private Render editRender;

	public boolean isEditRenderShow() {
		return editRenderShow;
	}

	public void setEditRenderShow(boolean editRenderShow) {
		this.editRenderShow = editRenderShow;
	}

	public int getEditRenderWay() {
		return editRenderWay;
	}

	public void setEditRenderWay(int editRenderWay) {
		this.editRenderWay = editRenderWay;
	}

	public String getEditValueGenWayJson() {
		return editValueGenWayJson;
	}

	public void setEditValueGenWayJson(String editValueGenWayJson) {
		this.editValueGenWayJson = editValueGenWayJson;
	}

	public String getEditValidateJson() {
		return editValidateJson;
	}

	public void setEditValidateJson(String editValidateJson) {
		this.editValidateJson = editValidateJson;
	}
	
	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	
	public boolean isGson() {
		return gson;
	}

	public void setGson(boolean gson) {
		this.gson = gson;
	}
	
	public String getColumnTitle() {
		if(columnTitle == null)
			columnTitle = getColumnCommon();
		return columnTitle;
	}

	public void setColumnTitle(String columnTitle) {
		this.columnTitle = columnTitle;
	}
	
	public Render getEditRender() {
		return editRender;
	}

	public void setEditRender(Render editRender) {
		this.editRender = editRender;
	}
	
	public String getEditValueJavaCode(){
		return EditValueGenWayHelper.javaCodeEdit(this);
	}
	
	public String getNewValueJavaCode(){
		return EditValueGenWayHelper.javaCodeNew(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((getTableName() == null) ? 0 : getTableName().hashCode());
		result = prime * result + ((getColumnName() == null) ? 0 : getColumnName().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableColumn other = (TableColumn) obj;
		if (getTableName() == null) {
			if (other.getTableName() != null)
				return false;
		} else if (!getTableName().equals(other.getTableName()))
			return false;
		if (getColumnName() == null) {
			if (other.getColumnName() != null)
				return false;
		} else if (!getColumnName().equals(other.getColumnName()))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(TableColumn o) {
		if(o == null)
			return -1;
		Integer s1 = this.getSeq();
		Integer s2 = o.getSeq();
		if(null == s1)
			return 1;
		if(null == s2){
			return -1;
		}
		return s1.compareTo(s2);
	}
}
